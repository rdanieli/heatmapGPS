package com.eng.univates.bd.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.eng.univates.bd.BairroBD;
import com.eng.univates.bd.OcorrenciaBD;
import com.eng.univates.pojo.Bairro;
import com.eng.univates.pojo.Filter;
import com.eng.univates.pojo.Ocorrencia;
import com.eng.univates.pojo.Usuario;
import com.eng.univates.setup.OcorrenciaSetup;
import com.eng.univates.setup.Setup;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.LatLng;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

@Stateless
public class OcorrenciaBDImpl extends CrudBDImpl<Ocorrencia, Integer> implements OcorrenciaBD {
	
	SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
	
	@EJB
	BairroBD bairroBD;
	
	@Override
	public Setup<Ocorrencia> getSetup() {
		return new OcorrenciaSetup();
	}

	private static String PROJECTION_OCORRENCIAS = "select o.id as \"sequence\", "
																									+ "o.logradouro as \"logradouro\", "
																									+ "o.bairro as \"bairro\", "
																									+ "o.fato as \"fato\", "
																									+ "o.dataregistro as \"dataRegistro\", "
																									+ "o.datafato as \"dataFato\", "
																									+ "o.horafato as \"horaFato\", "
																									+ "st_asgeojson(o.local) as jsonLocal from ocorrencias o ";
	
	@Override
	public List<Ocorrencia> getPontosConvertidos() {
		return getPontosConvertidos(null);
	}
	
	@SuppressWarnings("unchecked")
	private List<Ocorrencia> getPontosConvertidos(Filter filtro) {
		Session s = entityManager.unwrap(Session.class);
		
		StringBuilder sb = new StringBuilder( PROJECTION_OCORRENCIAS + " where 1=1 ");
		
		List par = new ArrayList();
				
		if ( filtro != null ) {
			if (filtro.getSelectedBairroId() != null && filtro.getSelectedBairroId() > 0) {
				Bairro bairro = new Bairro();
				bairro.setId(filtro.getSelectedBairroId());
				bairro = bairroBD.findOne(bairro);
				
				sb.append(" and ");
				sb.append(" ST_CONTAINS( ST_GeomFromText('SRID=4326;"+bairro.getGeom().toText()+"'), o.local) " );
			}
			
			if (filtro.getSelectedFato() != null && ! filtro.getSelectedFato().isEmpty()) {
				sb.append(" and ");
				sb.append(" o.fato = ? ");
				par.add(filtro.getSelectedFato());
			}
			
			if (filtro.getDtInicio() != null) {
				sb.append(" and ");
				sb.append(" o.datafato >= ? ");
				par.add(filtro.getDtInicio());
			}
			
			if (filtro.getDtFim() != null) {
				sb.append(" and ");
				sb.append(" o.datafato <= ? ");
				par.add(filtro.getDtFim());
			}
			
			if (filtro.getHrIni() != null) {
				sb.append(" and ");
				sb.append(" o.horafato >= ? ");
				par.add(sdfTime.format(filtro.getHrIni()));
			}
			
			if (filtro.getHrFim() != null) {
				sb.append(" and ");
				sb.append(" o.horafato <= ? ");
				par.add(sdfTime.format(filtro.getHrFim()));
			}
		}
		sb.append(" and o.local is not null ");
		SQLQuery query = s.createSQLQuery(sb.toString());
		
		for (int i = 0; i < par.size(); i++) {
			query.setParameter(i, par.get(i));
			System.out.println(par.get(i));
		}
		
		List<Ocorrencia> r = query.
						addScalar("sequence").
						addScalar("logradouro").
						addScalar("bairro").
						addScalar("fato").
						addScalar("dataRegistro", StandardBasicTypes.CALENDAR).
						addScalar("dataFato", StandardBasicTypes.CALENDAR).
						addScalar("horaFato").
						addScalar("jsonLocal").setResultTransformer(Transformers.aliasToBean(Ocorrencia.class)).list();
		
		return r;
	}
	
	
	@Override
	public List<Ocorrencia> filtraMapa(Filter filtro) {
		return getPontosConvertidos(filtro);
	}

	@Override
	public List<Ocorrencia> pontosBatalhao(Usuario usuario) {
Session s = entityManager.unwrap(Session.class);
		
		StringBuilder sb = new StringBuilder( PROJECTION_OCORRENCIAS + " where ");
		
		sb.append( "ST_CONTAINS( ST_GeomFromText('SRID=4326;"+usuario.getBatalhao().getGeom().toText()+"'), o.local)" );
		sb.append(" and o.local is not null ");
		
		//Order By ST_Distance(geometry g1, geometry g2);
		
		SQLQuery query = s.createSQLQuery(sb.toString());
		
		List<Ocorrencia> r = query.
						addScalar("sequence").
						addScalar("logradouro").
						addScalar("bairro").
						addScalar("fato").
						addScalar("dataRegistro", StandardBasicTypes.CALENDAR).
						addScalar("dataFato", StandardBasicTypes.CALENDAR).
						addScalar("horaFato").
						addScalar("jsonLocal").setResultTransformer(Transformers.aliasToBean(Ocorrencia.class)).list();
		
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDescricaoFatos() {
		return (List<String>)entityManager.createQuery("select distinct o.fato from Ocorrencia o order by o.fato").getResultList();
	}
	
	@Override
	public String convertPontosGeo() {
		final Geocoder geocoder = new Geocoder();
		WKTReader reader = new WKTReader();
		
		List<Ocorrencia> list = findAll(new WhereClause<Ocorrencia>() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void buildWhere(CriteriaQuery cq, CriteriaBuilder cb, Root root, Ocorrencia entity) {
				cq.where(cb.isNull(root.get("local")));
				
			}
		}, 200);
		
		Session session = entityManager.unwrap(Session.class);
		int count = 0;
		
		for (Ocorrencia i : list) {
			GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(i.getLogradouro() + ", Porto Alegre - RS").getGeocoderRequest();
			try {
				GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
				if (geocoderResponse.getResults().isEmpty()) {
					System.out.println(i.getSequence() + " - " + i.getLogradouro());
					continue;
				}
				LatLng v = geocoderResponse.getResults().get(0).getGeometry().getLocation();
				
				Point p = (Point) reader.read("POINT("+v.getLng()+" "+v.getLat()+")");
				p.setSRID(4326);
				
				i.setLocal(p);
				
				session.update(i); 
				if (++count % 50 == 0) {
					session.flush();
					session.clear();
				}
				
				if (count == 200) {
					break;
				}
			} catch (IOException | ParseException e) {
				System.out.println("Não converteu: - " + i.getSequence());
				e.printStackTrace();
			}
		} 
		
		return "Sucesso";
	}	
}


package com.eng.univates.bd.impl;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.eng.univates.bd.OcorrenciaBD;
import com.eng.univates.pojo.Ocorrencia;
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
	
	@Override
	public Setup<Ocorrencia> getSetup() {
		return new OcorrenciaSetup();
	}

	@Override
	public List<Ocorrencia> getPontosConvertidos() {
		Session s = entityManager.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		List<Ocorrencia> r = s.createSQLQuery("select o.id as \"sequence\", "
				+ "o.logradouro as \"logradouro\", "
				+ "o.bairro as \"bairro\", "
				+ "o.fato as \"fato\", "
				+ "o.dataregistro as \"dataRegistro\", "
				+ "o.datafato as \"dataFato\", "
				+ "o.horafato as \"horaFato\", "
				+ "st_asgeojson(o.local) as jsonLocal from ocorrencias o where o.local is not null").
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

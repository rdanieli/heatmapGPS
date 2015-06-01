package com.eng.univates.bd.impl;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	public String convertPontosGeo() {
//		Ocorrencia oc = new Ocorrencia();
//		oc.setBairro("Centro");
//		oc.setLogradouro("Muito maravilhoso");
//		oc.setDataFato(Calendar.getInstance());
//		oc.setDataRegistro(Calendar.getInstance());
//		oc.setFato("Consumado");
//		

//		
//		try {

//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	
		final Geocoder geocoder = new Geocoder();
		WKTReader reader = new WKTReader();
		
		List<Ocorrencia> list = findAll();
		
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
				
				if (count == 300) {
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

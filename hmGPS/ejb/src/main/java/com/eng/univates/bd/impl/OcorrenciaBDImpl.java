package com.eng.univates.bd.impl;

import java.util.Calendar;

import javax.ejb.Stateless;

import org.postgis.Point;

import com.eng.univates.bd.OcorrenciaBD;
import com.eng.univates.pojo.Ocorrencia;
import com.eng.univates.setup.OcorrenciaSetup;
import com.eng.univates.setup.Setup;

@Stateless
public class OcorrenciaBDImpl extends CrudBDImpl<Ocorrencia, Integer> implements OcorrenciaBD {
	
	@Override
	public Setup<Ocorrencia> getSetup() {
		return new OcorrenciaSetup();
	}

	@Override
	public String convertPontosGeo() {
		Ocorrencia oc = new Ocorrencia();
		oc.setBairro("Centro");
		oc.setLogradouro("Muito maravilhoso");
		oc.setDataFato(Calendar.getInstance());
		oc.setDataRegistro(Calendar.getInstance());
		oc.setFato("Consumado");
//		oc.setLocal(new Point(-55, 110));
		
		
		persist(oc);
		
		return "Sucesso";
	}
	
}

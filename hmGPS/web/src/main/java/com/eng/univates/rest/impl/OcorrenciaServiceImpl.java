package com.eng.univates.rest.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.eng.univates.rest.OcorrenciaService;
import com.eng.univates.rn.OcorrenciaRN;

@Stateless
public class OcorrenciaServiceImpl implements OcorrenciaService {

	@EJB
	OcorrenciaRN ocorrenciaRn;
	
	@Override
	public String converterPontosGeo() {
		return ocorrenciaRn.converterPontosGeo();
	}

}

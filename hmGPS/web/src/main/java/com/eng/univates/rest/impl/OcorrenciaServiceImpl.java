package com.eng.univates.rest.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.eng.univates.pojo.Filter;
import com.eng.univates.pojo.Ocorrencia;
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

	@Override
	public List<Ocorrencia> getPontosConvertidos() {
		return ocorrenciaRn.getPontosConvertidos();
	}

	@Override
	public List<String> getDescricaoFatos() {
		return ocorrenciaRn.getDescricaoFatos();
	}

	@Override
	public List<Ocorrencia> filtraMapa(Filter filtro) {
		System.out.println(filtro.getSelectedFato());
		return null;
	}	
}

package com.eng.univates.rn.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.eng.univates.bd.CrudBD;
import com.eng.univates.bd.OcorrenciaBD;
import com.eng.univates.pojo.Ocorrencia;
import com.eng.univates.rn.OcorrenciaRN;

@Stateless
public class OcorrenciaRNImpl extends CrudRNImpl<Ocorrencia, Integer> implements OcorrenciaRN {
	
	@EJB
	OcorrenciaBD occBD;
	
	@Override
	public CrudBD<Ocorrencia, Integer> getDAO() {
		return occBD;
	}

	@Override
	public List<Ocorrencia> getPontosConvertidos() {
		return occBD.getPontosConvertidos();
	}
	
	@Override
	public String converterPontosGeo() {
		return occBD.convertPontosGeo();
	}
}
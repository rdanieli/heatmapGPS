package com.eng.univates.rn;

import javax.ejb.Remote;

import com.eng.univates.pojo.Ocorrencia;

@Remote
public interface OcorrenciaRN extends CrudRN<Ocorrencia, Integer>{
	
	public String converterPontosGeo();
}

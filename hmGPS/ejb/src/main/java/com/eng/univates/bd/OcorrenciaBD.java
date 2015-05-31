package com.eng.univates.bd;

import javax.ejb.Remote;

import com.eng.univates.pojo.Ocorrencia;

@Remote
public interface OcorrenciaBD extends CrudBD<Ocorrencia, Integer> {
	public String convertPontosGeo();
}

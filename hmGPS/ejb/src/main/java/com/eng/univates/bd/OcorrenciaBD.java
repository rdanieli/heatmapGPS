package com.eng.univates.bd;

import java.util.List;

import javax.ejb.Remote;

import com.eng.univates.pojo.Ocorrencia;

@Remote
public interface OcorrenciaBD extends CrudBD<Ocorrencia, Integer> {
	public String convertPontosGeo();
	public List<Ocorrencia> getPontosConvertidos();
	public List<String> getDescricaoFatos();
}

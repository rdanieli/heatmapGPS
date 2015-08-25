package com.eng.univates.rn;

import java.util.List;

import javax.ejb.Remote;

import com.eng.univates.pojo.Filter;
import com.eng.univates.pojo.Ocorrencia;
import com.eng.univates.pojo.Usuario;

@Remote
public interface OcorrenciaRN extends CrudRN<Ocorrencia, Integer>{
	
	public String converterPontosGeo();
	public List<Ocorrencia> getPontosConvertidos();
	public List<String> getDescricaoFatos();
	public List<Ocorrencia> filtraMapa(Filter filtro);
	public List<Ocorrencia> pontosBatalhao(Usuario usuario);
	
}

package com.eng.univates.bd;

import java.util.List;

import javax.ejb.Remote;

import com.eng.univates.pojo.Filter;
import com.eng.univates.pojo.Ocorrencia;
import com.eng.univates.pojo.Usuario;
import com.vividsolutions.jts.geom.Point;

@Remote
public interface OcorrenciaBD extends CrudBD<Ocorrencia, Integer> {
	public String convertPontosGeo();
	
	public List<Ocorrencia> getPontosConvertidos();
	
	public List<String> getDescricaoFatos();
	
	public List<Ocorrencia> filtraMapa(Filter filtro);
	
	public List<Ocorrencia> pontosBatalhao(Usuario usuario, Point localViatura, Double distance);
}

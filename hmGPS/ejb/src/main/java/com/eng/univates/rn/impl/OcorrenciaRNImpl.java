package com.eng.univates.rn.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.eng.univates.bd.CrudBD;
import com.eng.univates.bd.OcorrenciaBD;
import com.eng.univates.pojo.Filter;
import com.eng.univates.pojo.Ocorrencia;
import com.eng.univates.pojo.Usuario;
import com.eng.univates.rn.OcorrenciaRN;
import com.eng.univates.rn.UsuarioRN;

@Stateless
public class OcorrenciaRNImpl extends CrudRNImpl<Ocorrencia, Integer> implements OcorrenciaRN {
	
	@EJB
	OcorrenciaBD occBD;
	
	@EJB
	UsuarioRN usuRN;
	
	@Override
	public CrudBD<Ocorrencia, Integer> getDAO() {
		return occBD;
	}

	@Override
	public List<Ocorrencia> getPontosConvertidos() {
		return occBD.getPontosConvertidos();
	}
	
	public List<String> getDescricaoFatos() {
		return occBD.getDescricaoFatos();
	}
	
	@Override
	public String converterPontosGeo() {
		return occBD.convertPontosGeo();
	}

	@Override
	public List<Ocorrencia> filtraMapa(Filter filtro) {
		return occBD.filtraMapa(filtro);
	}

	@Override
	public List<Ocorrencia> pontosBatalhao(Usuario usuario) {
		
		usuario = usuRN.findOne(usuario);
		
		return occBD.pontosBatalhao(usuario);
	}
}
package com.eng.univates.rn.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.eng.univates.bd.CrudBD;
import com.eng.univates.bd.OcorrenciaBD;
import com.eng.univates.bd.UsuarioBD;
import com.eng.univates.pojo.Ocorrencia;
import com.eng.univates.pojo.Usuario;
import com.eng.univates.rn.OcorrenciaRN;
import com.eng.univates.rn.UsuarioRN;

@Stateless
public class OcorrenciaRNImpl extends CrudRNImpl<Ocorrencia, Integer> implements OcorrenciaRN {
	
	@EJB
	OcorrenciaBD occBD;
	
	@Override
	public CrudBD<Ocorrencia, Integer> getDAO() {
		return occBD;
	}

	@Override
	public String converterPontosGeo() {
		return occBD.convertPontosGeo();
	}
}
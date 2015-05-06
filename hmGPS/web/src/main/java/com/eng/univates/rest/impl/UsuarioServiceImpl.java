package com.eng.univates.rest.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.PathParam;

import com.eng.univates.rest.UsuarioService;
import com.eng.univates.rn.UsuarioRN;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	@EJB
	UsuarioRN usuarioRn;
	
	@Override
	public String consulta(@PathParam("usuario") String usr) {
		usuarioRn.remover(null);
		return "Olá: " + usr;
	}
	
}

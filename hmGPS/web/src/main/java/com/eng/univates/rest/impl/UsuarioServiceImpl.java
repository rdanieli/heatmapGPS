package com.eng.univates.rest.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import com.eng.univates.builder.UsuarioBuilder;
import com.eng.univates.rest.UsuarioService;
import com.eng.univates.rn.UsuarioRN;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	@EJB
	UsuarioRN usuarioRn;
	
	@Context 
	HttpServletRequest request;
	
	@Override
	public String consulta(@PathParam("usuario") String usr) {
		return "Olá: " + usuarioRn.findOne(new UsuarioBuilder().comNome("rdanieli").build()).getLogin();
	}

	@Override
	public String auth(@FormParam("usr") String usr, @FormParam("pwd") String pwd) {
		
//		if (authenticate(username, password)) {
//        request.getSession(true);
//        // Set the session attributes as you wish
//    }
		
		return null;
	}
	
}

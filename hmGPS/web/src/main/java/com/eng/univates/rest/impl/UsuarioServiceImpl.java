package com.eng.univates.rest.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import com.eng.univates.builder.UsuarioBuilder;
import com.eng.univates.pojo.Usuario;
import com.eng.univates.rest.UsuarioService;
import com.eng.univates.rn.UsuarioRN;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	@EJB
	UsuarioRN usuarioRn;

	@Override	
	public String consulta(@PathParam("usuario") String usr) {
		return "Olá: " + usuarioRn.findOne(new UsuarioBuilder().comNome(usr).build()).getLogin();
	}

	@Override
	//considerando um dia utilizar HTTPS
	public Usuario auth(@Context HttpServletRequest request, @HeaderParam("usr") String usr, @HeaderParam("pwd") String pwd) {
		Usuario usuario = null;

		if ( (usuario = usuarioRn.findOne(new UsuarioBuilder(usr, pwd).build())) != null) {
			//request.getSession(true);
			usuario.setSenha(null);
		}

		return usuario;
	}

}

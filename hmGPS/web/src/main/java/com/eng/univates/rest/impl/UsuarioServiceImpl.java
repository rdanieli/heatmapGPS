package com.eng.univates.rest.impl;

import java.security.SecureRandom;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.util.Base64;

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
	public Usuario auth(@Context HttpServletRequest request, 
										  @HeaderParam("usr") String usr, 
										  @HeaderParam("pwd") String pwd) {
		Usuario usuario = null;
		
		try {
			if ((usuario = usuarioRn.login(new UsuarioBuilder(new String(Base64.decode(usr)), 
																												new String(Base64.decode(pwd))).build()))
																												!= null) {
				SecureRandom random = new SecureRandom();
				byte bytes[] = new byte[64];
				random.nextBytes(bytes);
				usuario.setToken(Base64.encodeBytes(bytes));

				usuario.setUltimoLogin(Calendar.getInstance());
				usuario.setUltimoRequest(Calendar.getInstance());
				usuarioRn.persistir(usuario);

				usuario.setSenha(null);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return usuario;
	}

	@Override
	public boolean logout(@HeaderParam("token") String token) {
		try {
			Usuario usuario = usuarioRn.findOne(new UsuarioBuilder().comToken(token).build());

			if (usuario != null) {
				usuario.setToken(null);
				usuario = usuarioRn.persistir(usuario);
				return usuario.getToken() == null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
		return false;
	}
}

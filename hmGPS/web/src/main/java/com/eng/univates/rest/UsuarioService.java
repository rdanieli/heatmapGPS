package com.eng.univates.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.eng.univates.pojo.Usuario;

@Path("/usuarios")
public interface UsuarioService {
	
	@GET	
	@Path("/{usuario}")
	public String consulta(@PathParam("usuario") String usr);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/auth")
	public Usuario auth(@Context HttpServletRequest request, @HeaderParam("usr") String usr, @HeaderParam("pwd") String pwd);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/logout")
	public boolean logout(@HeaderParam("token") String token);
}

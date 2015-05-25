package com.eng.univates.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eng.univates.pojo.Usuario;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UsuarioService {
	
	@GET	
	@Path("/{usuario}")
	public String consulta(@PathParam("usuario") String usr);

	@POST	
	@Path("/auth")
	public Usuario auth(String usr, String pwd);
	
	
}

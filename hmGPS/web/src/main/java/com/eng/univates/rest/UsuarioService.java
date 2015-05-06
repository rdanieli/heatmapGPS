package com.eng.univates.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/usuarios")
public interface UsuarioService {
	
	@GET	
	@Path("/{usuario}")
	public String consulta(@PathParam("usuario") String usr);
	
}

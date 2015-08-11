package com.eng.univates.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eng.univates.pojo.Bairro;

@Path("/bairros")
public interface BairroService {
	
	@GET	
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bairro> lista();
	
}

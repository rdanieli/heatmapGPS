package com.eng.univates.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ocorrencias")
public interface OcorrenciaService {
	
	@GET	
	@Path("/converter")
	public String converterPontosGeo();
	
}

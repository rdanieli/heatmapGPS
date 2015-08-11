package com.eng.univates.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eng.univates.pojo.Ocorrencia;

@Path("/ocorrencias")
public interface OcorrenciaService {
	
	@GET	
	@Path("/converter")
	public String converterPontosGeo();
	
	@GET	
	@Path("/descricaoFatos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getDescricaoFatos();
	
	@GET	
	@Path("/pontosConvertidos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ocorrencia> getPontosConvertidos();
	
}

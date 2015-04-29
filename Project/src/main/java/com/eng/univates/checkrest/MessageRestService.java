package com.eng.univates.checkrest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.junit.Test;

@Path("/message")
public class MessageRestService {
	
	@GET
	@Path("/{param}")
	public Response testRest( @PathParam("param") String msg ) {
		String result = "WebService Restful: " + msg;
		return Response.status(200).entity(result).build();
	}
}

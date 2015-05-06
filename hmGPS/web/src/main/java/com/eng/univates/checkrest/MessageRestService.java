package com.eng.univates.checkrest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.eng.univates.rn.UsuarioRN;
import com.eng.univates.rn.impl.UsuarioRNImpl;

@Path("/message")
@Stateless
@Produces(value="text/javascript")
public class MessageRestService {
	
	private UsuarioRN val = new UsuarioRNImpl();
	
	@GET
	@Path("/{param}")
	public Response testRest( @PathParam("param") String msg ) {
		String result = "WebService Restful: " + msg;
		val.persistir(null);
		return Response.status(200).entity(result).build();
	}

	/**
	 * @return the val
	 */
	public UsuarioRN getVal() {
		return val;
	}

	/**
	 * @param val the val to set
	 */
	public void setVal(UsuarioRN val) {
		this.val = val;
	}
}

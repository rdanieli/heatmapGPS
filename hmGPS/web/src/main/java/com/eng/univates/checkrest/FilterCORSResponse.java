package com.eng.univates.checkrest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class FilterCORSResponse implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		
//		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS");
//		responseContext.getHeaders().add("Access-Control-Request-Headers",requestContext.getHeaderString("Access-Control-Request-Headers"));
	}
}
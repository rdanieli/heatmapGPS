package com.eng.univates.checkrest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.eng.univates.rest.impl.OcorrenciaServiceImpl;
import com.eng.univates.rest.impl.UsuarioServiceImpl;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {
	
	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(UsuarioServiceImpl.class, 
																							 OcorrenciaServiceImpl.class, 
																							 //FilterCORSRequest.class,
																							 FilterCORSResponse.class));
	}

}

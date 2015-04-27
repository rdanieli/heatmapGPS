package com.eng.univates.checkrest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class HeatmapApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	 
	public HeatmapApplication() {
		singletons.add(new MessageRestService());
	}
 
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}	
}

package com.eng.univates.rest.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.util.Base64;

import com.eng.univates.pojo.Filter;
import com.eng.univates.pojo.Ocorrencia;
import com.eng.univates.pojo.Usuario;
import com.eng.univates.rest.OcorrenciaService;
import com.eng.univates.rn.OcorrenciaRN;

@Stateless
public class OcorrenciaServiceImpl implements OcorrenciaService {

	@EJB
	OcorrenciaRN ocorrenciaRn;
	
	@Override
	public String converterPontosGeo() {
		return ocorrenciaRn.converterPontosGeo();
	}

	@Override
	public List<Ocorrencia> getPontosConvertidos() {
		return ocorrenciaRn.getPontosConvertidos();
	}

	@Override
	public List<String> getDescricaoFatos() {
		return ocorrenciaRn.getDescricaoFatos();
	}

	@Override
	public List<Ocorrencia> filtraMapa(Filter filtro) {
		return ocorrenciaRn.filtraMapa(filtro);
	}

	@Override
	public List<Ocorrencia> pontosBatalhaoUsuario(@Context HttpServletRequest request, 
																					      @HeaderParam("login") String login, 
																					      @HeaderParam("token") String token) {
		
		Usuario usuario = new Usuario();
		try {
			usuario.setLogin(new String(Base64.decode(login)));
			usuario.setToken(new String(Base64.decode(token)));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ocorrenciaRn.pontosBatalhao(usuario);
	}	
}

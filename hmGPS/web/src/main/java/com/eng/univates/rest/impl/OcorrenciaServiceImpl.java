package com.eng.univates.rest.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.util.Base64;

import com.eng.univates.pojo.ConsultaRotaBatalhao;
import com.eng.univates.pojo.Filter;
import com.eng.univates.pojo.Ocorrencia;
import com.eng.univates.pojo.Usuario;
import com.eng.univates.rest.OcorrenciaService;
import com.eng.univates.rn.OcorrenciaRN;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.WKTReader;

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
																					      @HeaderParam("token") String token,
																					      ConsultaRotaBatalhao data ) {
		
		Usuario usuario = new Usuario();
		Point p = null;
		
		try {
			usuario.setLogin(new String(Base64.decode(login)));
			usuario.setToken(new String(Base64.decode(token)));
			
			p = (Point) new WKTReader().read("POINT("+data.getLng()+" "+data.getLat()+")");
			p.setSRID(4326);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ocorrenciaRn.pontosBatalhao(usuario, p, data.getDistance());
	}	
	
	@Override
	public Response carPolImg() {
		BufferedImage image;
		try {
			image = ImageIO.read(getClass().getResource("/img/car-pol.png"));
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ImageIO.write(image, "png", baos);
		    byte[] imageData = baos.toByteArray();
		    return Response.ok(new ByteArrayInputStream(imageData)).build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

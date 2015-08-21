package com.eng.univates.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.geotools.geojson.geom.GeometryJSON;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.MultiPolygon;

/**
 * @author Rafael-Danieli
 *
 */
@Table(name = "batalhoes")
@Entity
public class Batalhao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "gid")
	private Integer id;

	@Column(name = "name")
	private String nome;

	@Column(name = "geom")
	@Type(type = "org.hibernate.spatial.GeometryType")
	@JsonIgnore
	private MultiPolygon geom;
	
	@Transient
	private String jsonLocal;
	
	public Batalhao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public MultiPolygon getGeom() {
		return geom;
	}

	public void setGeom(MultiPolygon geom) {
		this.geom = geom;
	}

	public String getJsonLocal() {
		try {
			if( geom != null ) {
				String geoJson = new GeometryJSON().toString(geom);
				jsonLocal = geoJson;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonLocal;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}

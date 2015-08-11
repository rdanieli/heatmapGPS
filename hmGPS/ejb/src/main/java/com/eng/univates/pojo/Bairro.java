package com.eng.univates.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.MultiPolygon;

@Entity
@Table(name = "bairros")
public class Bairro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "gid")
	private Integer id;

	@Column(name = "bairro")
	private String nome;

	@Column(name = "codbairro")
	private Integer codBairro;

	@Column(name = "length")
	private Double length;

	@Column(name = "area")
	private Double area;

	@Column(name = "geom")
	@Type(type = "org.hibernate.spatial.GeometryType")
	@JsonIgnore
	private MultiPolygon geom;

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

	public Integer getCodBairro() {
		return codBairro;
	}

	public void setCodBairro(Integer codBairro) {
		this.codBairro = codBairro;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public MultiPolygon getGeom() {
		return geom;
	}

	public void setGeom(MultiPolygon geom) {
		this.geom = geom;
	}
	
}

package com.eng.univates.pojo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

@Table(name = "ocorrencias")
@Entity
public class Ocorrencia implements Serializable {

	private static final long serialVersionUID = 3882063975359906386L;

	@Id
	@GeneratedValue(generator = "my_gen")
	@SequenceGenerator(name = "my_gen", sequenceName = "ocorrencias_id_seq", allocationSize = 1)
	@Column(name = "id")
	private Integer sequence;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "fato")
	private String fato;

	@Column(name = "dataregistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataRegistro;

	@Column(name = "datafato")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataFato;

	@Column(name = "horafato")
	private String horaFato;

	@Column(name = "local")
	@Type(type = "org.hibernate.spatial.GeometryType")
	@JsonIgnore
	private Point local;

	@Transient
	private String jsonLocal;

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getFato() {
		return fato;
	}

	public void setFato(String fato) {
		this.fato = fato;
	}

	public Calendar getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Calendar getDataFato() {
		return dataFato;
	}

	public void setDataFato(Calendar dataFato) {
		this.dataFato = dataFato;
	}

	public String getHoraFato() {
		return horaFato;
	}

	public void setHoraFato(String horaFato) {
		this.horaFato = horaFato;
	}

	public Point getLocal() {
		return local;
	}

	public void setLocal(Point local) {
		this.local = local;
	}
	
	public String getJsonLocal() {
		return jsonLocal;
	}

	public void setJsonLocal(String jsonLocal) {
		this.jsonLocal = jsonLocal;
	}
	
}

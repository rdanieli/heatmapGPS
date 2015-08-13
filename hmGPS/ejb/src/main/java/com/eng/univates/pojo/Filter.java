package com.eng.univates.pojo;

import java.io.Serializable;
import java.util.Date;

public class Filter implements Serializable{
	
	private String selectedFato;
	private Integer selectedBairroId;
	private Date dtInicio;
	private Date dtFim;
	private Date hrIni;
	private Date hrFim;
	public String getSelectedFato() {
		return selectedFato;
	}
	public void setSelectedFato(String selectedFato) {
		this.selectedFato = selectedFato;
	}
	public Integer getSelectedBairroId() {
		return selectedBairroId;
	}
	public void setSelectedBairroId(Integer selectedBairroId) {
		this.selectedBairroId = selectedBairroId;
	}
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	public Date getDtFim() {
		return dtFim;
	}
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	public Date getHrIni() {
		return hrIni;
	}
	public void setHrIni(Date hrIni) {
		this.hrIni = hrIni;
	}
	public Date getHrFim() {
		return hrFim;
	}
	public void setHrFim(Date hrFim) {
		this.hrFim = hrFim;
	}
}

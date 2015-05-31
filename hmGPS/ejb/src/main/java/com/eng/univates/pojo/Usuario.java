package com.eng.univates.pojo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Rafael-Danieli
 *
 */
@Table(name = "usuarios")
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -760190790775962026L;

	@Id
	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String senha;

	@Column(name = "dt_ultimo_login")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar ultimoLogin;

	@Column(name = "token")
	private String token;

	@Column(name = "dt_ultimo_request")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar ultimoRequest;

	public Usuario() {
	}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *          the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *          the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the ultimoLogin
	 */
	public Calendar getUltimoLogin() {
		return ultimoLogin;
	}

	/**
	 * @param ultimoLogin
	 *          the ultimoLogin to set
	 */
	public void setUltimoLogin(Calendar ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Calendar getUltimoRequest() {
		return ultimoRequest;
	}

	public void setUltimoRequest(Calendar ultimoRequest) {
		this.ultimoRequest = ultimoRequest;
	}

	@Override
	public String toString() {
		return this.login;
	}
}

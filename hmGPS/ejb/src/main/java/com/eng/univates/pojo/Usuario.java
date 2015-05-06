package com.eng.univates.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rafael-Danieli
 *
 */
@Table( name = "usuarios" )
@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = -760190790775962026L;

	@Id
	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	private String senha;
	
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
	 * @param login the login to set
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
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return this.login;
	}
}

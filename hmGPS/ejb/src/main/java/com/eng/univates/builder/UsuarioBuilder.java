package com.eng.univates.builder;

import com.eng.univates.pojo.Usuario;

public class UsuarioBuilder implements Builder<Usuario>{
	
	private Usuario usuario;
	
	public UsuarioBuilder() {
		usuario = new Usuario();
	}

	public UsuarioBuilder(String login, String senha) {
		usuario = new Usuario(login,senha);
	}
	
	public UsuarioBuilder comNome(String login) {
		usuario.setLogin(login);
		return this;
	}

	public UsuarioBuilder comSenha(String login) {
		usuario.setSenha(login);
		return this;
	}

	public UsuarioBuilder comToken(String token) {
		usuario.setToken(token);
		return this;
	}
	
	@Override
	public Usuario build() {
		return usuario;
	}
}

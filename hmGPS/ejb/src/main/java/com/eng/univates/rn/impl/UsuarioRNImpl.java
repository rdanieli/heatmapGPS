package com.eng.univates.rn.impl;

import javax.ejb.Stateless;

import com.eng.univates.pojo.Usuario;
import com.eng.univates.rn.UsuarioRN;

@Stateless
public class UsuarioRNImpl extends CrudRNImpl<Usuario, String> implements UsuarioRN {

	@Override
	public Usuario remover(Usuario entity) {
		System.err.println("Removendo Usuario Rafael");
		return new Usuario("rafael", "ticoduro");
	}
	
}

package com.eng.univates.bd.impl;

import javax.ejb.Stateless;

import com.eng.univates.bd.UsuarioBD;
import com.eng.univates.pojo.Usuario;
import com.eng.univates.setup.Setup;
import com.eng.univates.setup.UsuarioSetup;

@Stateless
public class UsuarioBDImpl extends CrudBDImpl<Usuario, String> implements UsuarioBD {
	
	@Override
	public Setup<Usuario> getSetup() {
		return new UsuarioSetup();
	}
	
}

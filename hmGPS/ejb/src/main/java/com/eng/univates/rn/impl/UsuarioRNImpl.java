package com.eng.univates.rn.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.eng.univates.bd.CrudBD;
import com.eng.univates.bd.UsuarioBD;
import com.eng.univates.pojo.Usuario;
import com.eng.univates.rn.UsuarioRN;

@Stateless
public class UsuarioRNImpl extends CrudRNImpl<Usuario, String> implements UsuarioRN {
	
	@EJB
	UsuarioBD usuarioBD;
	
	@Override
	public CrudBD<Usuario, String> getDAO() {
		return usuarioBD;
	}
}
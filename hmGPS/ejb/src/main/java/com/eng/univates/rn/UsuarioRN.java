package com.eng.univates.rn;

import javax.ejb.Remote;

import com.eng.univates.pojo.Usuario;

@Remote
public interface UsuarioRN extends CrudRN<Usuario, String>{
	
}

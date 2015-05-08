package com.eng.univates.bd;

import javax.ejb.Remote;

import com.eng.univates.pojo.Usuario;

@Remote
public interface UsuarioBD extends CrudBD<Usuario, String> {
}

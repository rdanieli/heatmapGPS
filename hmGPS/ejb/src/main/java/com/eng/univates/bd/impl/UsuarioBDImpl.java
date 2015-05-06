package com.eng.univates.bd.impl;

import javax.ejb.Stateless;

import com.eng.univates.bd.UsuarioBD;
import com.eng.univates.pojo.Usuario;

@Stateless
public class UsuarioBDImpl extends CrudBDImpl<Usuario, String> implements UsuarioBD {

}

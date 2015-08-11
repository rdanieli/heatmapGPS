package com.eng.univates.bd;

import javax.ejb.Remote;

import com.eng.univates.pojo.Bairro;

@Remote
public interface BairroBD extends CrudBD<Bairro, Integer> {
}

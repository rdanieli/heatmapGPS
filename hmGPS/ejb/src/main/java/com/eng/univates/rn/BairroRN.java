package com.eng.univates.rn;

import javax.ejb.Remote;

import com.eng.univates.pojo.Bairro;

@Remote
public interface BairroRN extends CrudRN<Bairro, Integer>{
	
}

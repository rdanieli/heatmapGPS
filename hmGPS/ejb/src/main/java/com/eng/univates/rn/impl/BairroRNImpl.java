package com.eng.univates.rn.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.eng.univates.bd.BairroBD;
import com.eng.univates.bd.CrudBD;
import com.eng.univates.pojo.Bairro;
import com.eng.univates.rn.BairroRN;

@Stateless
public class BairroRNImpl extends CrudRNImpl<Bairro, Integer> implements BairroRN {
	
	@EJB
	BairroBD occBD;
	
	@Override
	public CrudBD<Bairro, Integer> getDAO() {
		return occBD;
	}
}
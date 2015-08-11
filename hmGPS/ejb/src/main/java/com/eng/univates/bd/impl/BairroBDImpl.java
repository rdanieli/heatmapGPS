package com.eng.univates.bd.impl;

import javax.ejb.Stateless;

import com.eng.univates.bd.BairroBD;
import com.eng.univates.pojo.Bairro;
import com.eng.univates.setup.BairroSetup;
import com.eng.univates.setup.Setup;

@Stateless
public class BairroBDImpl extends CrudBDImpl<Bairro, Integer> implements BairroBD {
	
	@Override
	public Setup<Bairro> getSetup() {
		return new BairroSetup();
	}
}

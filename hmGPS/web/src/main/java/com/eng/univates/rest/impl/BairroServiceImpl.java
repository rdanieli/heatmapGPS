package com.eng.univates.rest.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.eng.univates.pojo.Bairro;
import com.eng.univates.rest.BairroService;
import com.eng.univates.rn.BairroRN;

@Stateless
public class BairroServiceImpl implements BairroService {

	@EJB
	BairroRN bairroRn;

	@Override
	public List<Bairro> lista() {
		return bairroRn.listarTodos();
	}
}

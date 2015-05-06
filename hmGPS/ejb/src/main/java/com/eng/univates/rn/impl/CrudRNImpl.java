package com.eng.univates.rn.impl;

import java.util.List;

import com.eng.univates.bd.CrudBD;
import com.eng.univates.bd.impl.CrudBDImpl;
import com.eng.univates.rn.CrudRN;

public class CrudRNImpl<T, ID> implements CrudRN<T, ID> {

	private CrudBD<T, ID> crudBD;
	
//	@PostConstruct
	public void init(){
		crudBD = new CrudBDImpl<T, ID>();
	}
	
	@Override
	public T remover(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T persistir(T entity) {
		return crudBD.persist(entity);
	}

	/**
	 * @return the crudBD
	 */
	public CrudBD<T, ID> getCrudBD() {
		return crudBD;
	}

	/**
	 * @param crudBD the crudBD to set
	 */
	public void setCrudBD(CrudBD<T, ID> crudBD) {
		this.crudBD = crudBD;
	}
	
}

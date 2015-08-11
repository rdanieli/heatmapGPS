package com.eng.univates.rn.impl;

import java.util.List;

import javax.ejb.Stateless;

import com.eng.univates.rn.CrudRN;

@Stateless
public class CrudRNImpl<T, ID> implements CrudRN<T, ID> {

	@Override
	public T remover(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listarTodos() {
		return getDAO().findAll();
	}

	@Override
	public T persistir(T entity) {
		return getDAO().persist(entity);
	}

	/* (non-Javadoc)
	 * @see com.eng.univates.rn.CrudRN#findOne(java.lang.Object)
	 */
	@Override
	public T findOne(T entity) {
		return getDAO().findOne(entity);
	}
	
	public com.eng.univates.bd.CrudBD<T,ID> getDAO() {
		return null;
	}
}

package com.eng.univates.bd.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.eng.univates.bd.CrudBD;

public class CrudBDImpl<T,ID> implements CrudBD<T,ID> {

	@PersistenceContext 
	EntityManager entityManager;
	
	@Override
	public T persist(T entity) {
		System.out.println("Olá Mundo");
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T delete(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

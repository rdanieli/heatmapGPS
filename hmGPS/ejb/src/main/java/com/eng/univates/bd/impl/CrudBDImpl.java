package com.eng.univates.bd.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import com.eng.univates.bd.CrudBD;

public class CrudBDImpl<T,ID> implements CrudBD<T,ID> {

	@PersistenceContext 
	EntityManager entityManager;
	
	@Override
	public T persist(T entity) {
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findOne(T entity) {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<? extends Object> cq = cb.createQuery(entity.getClass());
		
		Root root = cq.from(entity.getClass());
		//setup
		TypedQuery q = entityManager.createQuery(cq);
		return (T) q.getSingleResult();
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

	public CriteriaBuilder getCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}

}

package com.eng.univates.bd.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.eng.univates.bd.CrudBD;
import com.eng.univates.setup.Setup;

@Stateless
public class CrudBDImpl<T,ID> implements CrudBD<T,ID> {

	@PersistenceContext(unitName="heatmapGPS")
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
	public Setup<T> getSetup() {
		throw new IllegalArgumentException("override o metodo setup");
	}
	
	@Override
	public T findOne(T entity) {
		if (entity == null) {
			throw new IllegalArgumentException("Informe uma entity.");
		}
		
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<? extends Object> cq = cb.createQuery(entity.getClass());
		
		Root root = cq.from(entity.getClass());
		
		cq.where(getSetup().setup(cb, root, entity));
		
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

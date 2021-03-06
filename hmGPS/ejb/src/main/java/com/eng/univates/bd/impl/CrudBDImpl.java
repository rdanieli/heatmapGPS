package com.eng.univates.bd.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.eng.univates.bd.CrudBD;
import com.eng.univates.setup.Setup;

@Stateless
@SuppressWarnings( {"unchecked", "rawtypes"})
public class CrudBDImpl<T,ID> implements CrudBD<T,ID> {

	@PersistenceContext(unitName="heatmapGPS")
	EntityManager entityManager;
	
	@Override	
	public T persist(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public List<T> findAll() {
		return findAll(null, 0);
	}
	
	@Override
	public List<T> findAll(WhereClause<T> whereClause, int max) {
		Type type = getClass().getGenericSuperclass();
		
		ParameterizedType a = (ParameterizedType) type;
		
    Type actualType = a.getActualTypeArguments()[0];
		
		CriteriaBuilder cb = getCriteriaBuilder();
		
		CriteriaQuery<? extends Object> cq = cb.createQuery((Class<T>)actualType);
		Root root = cq.from((Class<T>)actualType);
		
		if(whereClause != null) {
			whereClause.buildWhere(cq, cb, root, null);
		}
		
		Order order = getSetup().orderBy(cb, root);
		
		if(order != null) {
			cq.orderBy(order);
		}
		
		TypedQuery q = entityManager.createQuery(cq);
		
		if (max > 0){
			q.setMaxResults(max);
		}
		
		List<T> result = null;
		try {
	    result = (List<T>) q.getResultList();
		} catch (NoResultException e) {
		    System.out.println("No result forund for... ");
		}
		
		return result;
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
		
		defaultClause.buildWhere(cq, cb, root, entity);
		
		TypedQuery q = entityManager.createQuery(cq);	
		
		
		T result = null;
		try {
		    result = (T) q.getSingleResult();
		} catch (NoResultException e) {
		    System.out.println("No result forund for... ");
		}
		return result;
	}
	
	public interface WhereClause<T> {
		void buildWhere(CriteriaQuery cq, CriteriaBuilder cb, Root root, T entity);
	}
	
	private WhereClause<T> defaultClause = new WhereClause<T>() {
		
		@Override
		public void buildWhere(CriteriaQuery cq, CriteriaBuilder cb, Root root, T entity) {
			List<Predicate> list = new ArrayList<Predicate>();
			
			getSetup().setup(cb, root, entity, list);
			
			if(!list.isEmpty()) {
				cq.where(list.toArray(new Predicate[list.size()]));
			}
		}
	};

	@Override
	public T findById(ID id) {
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

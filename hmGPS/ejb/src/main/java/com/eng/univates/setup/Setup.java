package com.eng.univates.setup;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface Setup<T> {
	public Predicate[] setup(CriteriaBuilder cb, Root from,T entity);
}

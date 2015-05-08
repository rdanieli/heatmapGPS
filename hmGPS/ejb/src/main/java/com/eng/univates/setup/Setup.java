package com.eng.univates.setup;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface Setup<T> {
	public void setup(CriteriaBuilder cb, Root from,T entity, List<Predicate> p);
}

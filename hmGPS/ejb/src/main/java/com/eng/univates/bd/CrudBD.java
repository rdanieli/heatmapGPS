package com.eng.univates.bd;

import java.util.List;

import com.eng.univates.bd.impl.CrudBDImpl.WhereClause;
import com.eng.univates.setup.Setup;

public interface CrudBD<E,ID> {
	
	public E persist(E entity);
	
	public List<E> findAll();
	public List<E> findAll(WhereClause<E> whereClause, int max);
	
	public E findById(ID id);
	public E findOne(E entity);
	public E delete(E entity);
	
	public Setup<E> getSetup();
}

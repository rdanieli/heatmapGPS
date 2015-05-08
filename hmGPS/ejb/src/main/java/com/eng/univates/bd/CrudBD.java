package com.eng.univates.bd;

import java.util.List;

import com.eng.univates.setup.Setup;

public interface CrudBD<E,ID> {
	
	public E persist(E entity);
	public List<E> findAll();
	public E findById(ID id);
	public E findOne(E entity);
	public E delete(E entity);
	
	public Setup<E> getSetup();
}

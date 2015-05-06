package com.eng.univates.bd;

import java.util.List;

public interface CrudBD<T,ID> {
	
	public T persist(T entity);
	public List<T> findAll();
	public T findById(ID id);
	public T delete(T entity);
	
}

package com.eng.univates.rn;

import java.util.List;

public interface CrudRN<T,ID> {
	public T remover(T entity);
	public List<T> listarTodos();
	public T findOne(T entity);
	public T persistir(T entity);
}

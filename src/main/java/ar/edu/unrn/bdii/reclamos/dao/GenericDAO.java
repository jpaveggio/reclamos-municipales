package ar.edu.unrn.bdii.reclamos.dao;

import java.util.Set;


public interface GenericDAO<T> {
	
	T findById(String id);
	Set<T> findAll();
	void insert(T t);
	void update(T t);
	void delete(T t);
	
}

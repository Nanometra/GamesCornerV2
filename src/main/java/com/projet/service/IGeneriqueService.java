package com.projet.service;

import java.util.List;

public interface IGeneriqueService<T> {

	T find(Integer id);
	
	List<T> findAll();
	
	void add (T entity);
	
	void delete (Integer id);
	
	void update (T entity);	
	
}

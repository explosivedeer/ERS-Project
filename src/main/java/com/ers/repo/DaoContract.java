package com.ers.repo;

import java.util.List;

public interface DaoContract<T, I> {

	List<T> findAll();
	
	boolean verifyUser(T t);
	
	int getRole(T t);
	
	T findById(I i);
	
	int update(T t);
	
	int create(T t);
	
	T delete(I i);
	
	T findByUsername(String username);
}

package com.example.crud.service;

import java.util.List;

public interface ICrudSevice<T, ID> {

	T getById(ID id);

	List<T> getAll();

	T save(T t);

	T update(T t);

	void delete(T t);
	
	void deleteById(ID id);
}

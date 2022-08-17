package com.example.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.EmpleadoEntity;

@Repository
public interface EmpleadoRepository  extends CrudRepository<EmpleadoEntity, Integer>{
	
}

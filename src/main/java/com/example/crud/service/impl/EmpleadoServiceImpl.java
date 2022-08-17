package com.example.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.EmpleadoEntity;
import com.example.crud.repository.EmpleadoRepository;
import com.example.crud.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public EmpleadoEntity getById(Integer id) {
		return empleadoRepository.findById(id).orElseThrow();
	}

	@Override
	public List<EmpleadoEntity> getAll() {
		return (List<EmpleadoEntity>) empleadoRepository.findAll();
	}

	@Override
	public EmpleadoEntity save(EmpleadoEntity t) {
		return empleadoRepository.save(t);
	}

	@Override
	public EmpleadoEntity update(EmpleadoEntity t) {
		return empleadoRepository.save(t);
	}

	@Override
	public void delete(EmpleadoEntity t) {
		empleadoRepository.delete(t);
	}
}

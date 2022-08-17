package com.example.crud.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.EmpleadoEntity;
import com.example.crud.service.impl.EmpleadoServiceImpl;
import com.example.crud.util.IntegerUtils;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadoServiceImpl empleadoService;
	

	@PostMapping
	public ResponseEntity<EmpleadoEntity> create(@RequestBody EmpleadoEntity empleado){
		if(empleado == null) {
			return ResponseEntity.badRequest().build();
		}
		try {
			empleado = empleadoService.save(empleado);
		}catch (Exception e) {
			return	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(empleado);
	}
	
	@PutMapping
	public ResponseEntity<EmpleadoEntity> update(@RequestBody EmpleadoEntity empleado){
		if(empleado == null) {
			return ResponseEntity.badRequest().build();
		}
		try {
			empleado = empleadoService.update(empleado);
		}catch (Exception e) {
			return	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(empleado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EmpleadoEntity> delete(@PathVariable Integer id){
		
		try {
			 empleadoService.deleteById(id);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmpleadoEntity> getById(@PathVariable String id){
		Integer idEmpleado = null;
		if(IntegerUtils.isNumber(id)) {
			idEmpleado = Integer.parseInt(id);
		}else {
			return ResponseEntity.badRequest().build();
		}
		EmpleadoEntity empleado = new EmpleadoEntity();
		try {
			empleado = empleadoService.getById(idEmpleado);			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(empleado);
	}
	

}

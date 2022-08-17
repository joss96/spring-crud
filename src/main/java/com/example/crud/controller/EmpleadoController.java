package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crud.entity.EmpleadoEntity;
import com.example.crud.service.impl.EmpleadoServiceImpl;

@Controller
@RequestMapping
public class EmpleadoController {

	@Autowired
	private EmpleadoServiceImpl empleadoService;

	@GetMapping({ "/", "/empleados" })
	public String index(Model model) {
		List<EmpleadoEntity> empleados = empleadoService.getAll();
		model.addAttribute("saludo", "hola hh");
		model.addAttribute("empleados", empleados);
		return "index";
	}

	@GetMapping("/registro")
	public String registro(Model model, @RequestParam(required = false) Integer id) {
		EmpleadoEntity empleado = id != null ? empleadoService.getById(id) : new EmpleadoEntity();
		model.addAttribute("empleado", empleado);
		return "registro";
	}

	@PostMapping("/guardar")
	public String guardar(EmpleadoEntity empleado, Model model) {
		if (empleado.getEmpleadoId() == null) {
			empleadoService.save(empleado);
		} else {
			empleadoService.update(empleado);
		}
		return "redirect:empleados";
	}

	@GetMapping("/eliminar")
	public String eliminar(@RequestParam Integer id) {
			empleadoService.delete(id);
		return "redirect:empleados";
	}

}

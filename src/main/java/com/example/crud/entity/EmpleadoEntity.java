package com.example.crud.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpleadoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empleadoId;
	private String nombre;
	private String apellidos;
	private Integer edad;
	private Double salario;
}

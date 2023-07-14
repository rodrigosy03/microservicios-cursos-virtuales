package com.servicio.mscursos.entidades;

import java.time.LocalDate;
import javax.persistence.Entity;                                                        
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Curso {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFinalizacion;

	public Curso() {
		super();
	}
}

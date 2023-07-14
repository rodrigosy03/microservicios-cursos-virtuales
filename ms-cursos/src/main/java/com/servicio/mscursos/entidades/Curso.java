package com.servicio.mscursos.entidades;

import java.time.LocalDateTime;

import javax.persistence.Entity;                                                        
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Curso {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;

	private String nombre;
	private String descripcion;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFinalizacion;
	private int idProfesor;
}

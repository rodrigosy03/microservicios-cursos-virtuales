package com.servicio.msinscripciones.entidades;

import javax.persistence.Entity;                                                        
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInscripcion;

    private int idEstudiante;
    private int idCurso;
}

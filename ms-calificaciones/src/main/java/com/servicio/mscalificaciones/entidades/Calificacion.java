package com.servicio.mscalificaciones.entidades;

import javax.persistence.Entity;                                                        
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float nota;
    private int estudianteId;
    private int cursoId;

    public Calificacion() {
        super();
    }
}

package com.servicio.msestudiantes.modelos;

import lombok.Data;

@Data
public class Calificacion {
    private float nota;
    private int cursoId;
    private int estudianteId;

    public Calificacion(){
        super();
    }
}

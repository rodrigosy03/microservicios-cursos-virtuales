package com.servicio.msestudiantes.modelos;

import lombok.Data;

@Data
public class Inscripcion {
    private int idCurso;
    private int idEstudiantes;

    public Inscripcion(){
        super();
    }
}

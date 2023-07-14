package com.servicio.mscalificaciones.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicio.mscalificaciones.entidades.Calificacion;
import com.servicio.mscalificaciones.repositorio.CalificacionRepository;

@Service
public class CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Calificacion> getCalificaciones() {
        return calificacionRepository.findAll();
    }

    public Calificacion getCalificacionPorId(int id) {
        return calificacionRepository.findById(id).orElse(null);
    }

    public Calificacion crearCalificacion(Calificacion calificacion) {
        Calificacion calificacionNuevo = calificacionRepository.save(calificacion);
        return calificacionNuevo;
    }

    public List<Calificacion> getPorEstudiante(int idEstudiante) {
        return calificacionRepository.getPorEstudiante(idEstudiante);
    }

    public List<Calificacion> getPorCurso(int idCurso) {
        return calificacionRepository.getPorCurso(idCurso);
    }
}

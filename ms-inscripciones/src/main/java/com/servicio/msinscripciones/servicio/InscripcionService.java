package com.servicio.msinscripciones.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicio.msinscripciones.entidades.Inscripcion;
import com.servicio.msinscripciones.repositorio.InscripcionRepository;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<Inscripcion> getInscripciones() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion getInscripcionPorId(int id) {
        return inscripcionRepository.findById(id).orElse(null);
    }

    public Inscripcion crearInscripcion(Inscripcion inscripcion) {
        Inscripcion inscripcionNuevo = inscripcionRepository.save(inscripcion);
        return inscripcionNuevo;
    }

    public List<Inscripcion> getPorEstudiante(int idEstudiante) {
        return inscripcionRepository.findByEstudianteId(idEstudiante);
    }

    public List<Inscripcion> getPorCurso(int idCurso) {
        return inscripcionRepository.findByCursoId(idCurso);
    }
}

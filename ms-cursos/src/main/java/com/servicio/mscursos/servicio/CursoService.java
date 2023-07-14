package com.servicio.mscursos.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicio.mscursos.entidades.Curso;
import com.servicio.mscursos.modelos.Calificacion;
import com.servicio.mscursos.modelos.Inscripcion;
import com.servicio.mscursos.repositorio.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    public Curso getCursoPorId(int id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso crearCurso(Curso curso) {
        Curso cursoNuevo = cursoRepository.save(curso);
        return cursoNuevo;
    }

    public List<Calificacion> getCalificacionesDelCurso(int idCurso) { 
        List<Calificacion> calificaciones = restTemplate.getForObject("http://localhost:5003/calificaciones/curso/" + idCurso, List.class);
        
        return calificaciones;
    }

    public List<Inscripcion> getInscripcionesDelCurso(int idCurso) { 
        List<Inscripcion> inscripciones = restTemplate.getForObject("http://localhost:5004/inscripciones/curso/" + idCurso, List.class);
        
        return inscripciones;
    }
}

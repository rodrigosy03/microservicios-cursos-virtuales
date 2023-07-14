package com.servicio.msestudiantes.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicio.msestudiantes.entidades.Estudiante;
import com.servicio.msestudiantes.modelos.Calificacion;
import com.servicio.msestudiantes.modelos.Inscripcion;
import com.servicio.msestudiantes.repositorio.EstudianteRepository;

@Service
public class EstudianteService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante getEstudiantePorId(int id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        Estudiante estudianteNuevo = estudianteRepository.save(estudiante);
        return estudianteNuevo;
    }

    public List<Inscripcion> getInscripcionesDelEstudiante(int idEstudiante) { 
        List<Inscripcion> inscripciones = restTemplate.getForObject("http://localhost:8004/inscripciones/estudiante/" + idEstudiante, List.class);

        return inscripciones;
    }

    public List<Calificacion> getCalificacionesDelEstudiante(int idEstudiante) { 
        List<Calificacion> calificaciones = restTemplate.getForObject("http://localhost:8005/calificaciones/estudiante/" + idEstudiante, List.class);
        
        return calificaciones;
    }
}

package com.servicio.msestudiantes.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// import com.servicio.feignclients.CalificacionFeignClient;
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

    // @Autowired
    // private CalificacionFeignClient calificacionFeignClient;

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

    // Usando RestTemplate
    public List<Inscripcion> getInscripcionesDelEstudiante(int idEstudiante) { 
        List<Inscripcion> inscripciones = restTemplate.getForObject("http://localhost:5004/inscripciones/estudiante/" + idEstudiante, List.class);

        return inscripciones;
    }

    public List<Calificacion> getCalificacionesDelEstudiante(int idEstudiante) { 
        List<Calificacion> calificaciones = restTemplate.getForObject("http://localhost:5003/calificaciones/estudiante/" + idEstudiante, List.class);
        
        return calificaciones;
    }

    // Usando FeignClient
    // public Calificacion saveCalificacion(int estudianteId, Calificacion calificacion) {
    //     calificacion.setEstudianteId(estudianteId);
    //     Calificacion nuevaCalificacion = calificacionFeignClient.crear(calificacion);

    //     return nuevaCalificacion;
    // }
}

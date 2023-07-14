package com.servicio.msestudiantes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.msestudiantes.entidades.Estudiante;
import com.servicio.msestudiantes.modelos.Calificacion;
import com.servicio.msestudiantes.modelos.Inscripcion;
import com.servicio.msestudiantes.servicio.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.getEstudiantes();
        
        if (estudiantes.isEmpty()){
            return ResponseEntity.noContent().build();
        } 
        
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable("id") int id) {
        Estudiante estudiante = estudianteService.getEstudiantePorId(id);

        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estudiante);
    }

    @PostMapping("crear")
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.crearEstudiante(estudiante);
        return ResponseEntity.ok(nuevoEstudiante);
    }

    @GetMapping("/inscripciones/{idEstudiante}")
    public ResponseEntity<List<Inscripcion>> listarInscripcionesDelEstudiante(@PathVariable("idEstudiante") int idEstudiante) {
        Estudiante estudiante = estudianteService.getEstudiantePorId(idEstudiante);

        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }

        List<Inscripcion> inscripciones = estudianteService.getInscripcionesDelEstudiante(idEstudiante);
        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/calificaciones/{idEstudiante}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesDelEstudiante(@PathVariable("idEstudiante") int idEstudiante) {
        Estudiante estudiante = estudianteService.getEstudiantePorId(idEstudiante);

        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }

        List<Calificacion> calificaciones = estudianteService.getCalificacionesDelEstudiante(idEstudiante);
        return ResponseEntity.ok(calificaciones);
    }
}

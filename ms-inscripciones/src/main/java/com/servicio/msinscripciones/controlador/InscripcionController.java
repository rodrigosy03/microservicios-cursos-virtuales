package com.servicio.msinscripciones.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.msinscripciones.entidades.Inscripcion;
import com.servicio.msinscripciones.servicio.InscripcionService;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Inscripcion>> listarInscripciones() {
        List<Inscripcion> inscripciones = inscripcionService.getInscripciones();
        
        if (inscripciones.isEmpty()){
            return ResponseEntity.noContent().build();
        } 
        
        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<Inscripcion> obtenerInscripcion(@PathVariable("id") int id) {
        Inscripcion inscripcion = inscripcionService.getInscripcionPorId(id);

        if (inscripcion == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(inscripcion);
    }

    @PostMapping("crear")
    public ResponseEntity<Inscripcion> crearInscripcion(@RequestBody Inscripcion inscripcion) {
        Inscripcion nuevoInscripcion = inscripcionService.crearInscripcion(inscripcion);
        return ResponseEntity.ok(nuevoInscripcion);
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public ResponseEntity<List<Inscripcion>> listarInscripcionesPorEstudiante(@PathVariable("idEstudiante") int idEstudiante) {
        List<Inscripcion> inscripciones = inscripcionService.getPorEstudiante(idEstudiante);

        if (inscripciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/curso/{idCurso}")
    public ResponseEntity<List<Inscripcion>> listarInscripcionesPorCurso(@PathVariable("idCurso") int idCurso) {
        List<Inscripcion> inscripciones = inscripcionService.getPorCurso(idCurso);

        if (inscripciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(inscripciones);
    }
}

package com.servicio.mscalificaciones.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.mscalificaciones.entidades.Calificacion;
import com.servicio.mscalificaciones.servicio.CalificacionService;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Calificacion>> listarCalificaciones() {
        List<Calificacion> calificaciones = calificacionService.getCalificaciones();
        
        if (calificaciones.isEmpty()){
            return ResponseEntity.noContent().build();
        } 
        
        return ResponseEntity.ok(calificaciones);
    }

    @GetMapping("listar/{idEstudiante}")
    public ResponseEntity<Calificacion> obtenerCalificacion(@PathVariable("idEstudiante") int id) {
        Calificacion calificacion = calificacionService.getCalificacionPorId(id);

        if (calificacion == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(calificacion);
    }

    @PostMapping("crear")
    public ResponseEntity<Calificacion> crearCalificacion(@RequestBody Calificacion calificacion) {
        Calificacion nuevoCalificacion = calificacionService.crearCalificacion(calificacion);
        return ResponseEntity.ok(nuevoCalificacion);
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorEstudiante(@PathVariable("idEstudiante") int id) {
        List<Calificacion> calificaciones = calificacionService.getPorEstudiante(id);

        if (calificaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(calificaciones);
    }

    @GetMapping("/curso/{idCurso}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorCurso(@PathVariable("idCurso") int id) {
        List<Calificacion> calificaciones = calificacionService.getPorCurso(id);

        if (calificaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(calificaciones);
    }
}

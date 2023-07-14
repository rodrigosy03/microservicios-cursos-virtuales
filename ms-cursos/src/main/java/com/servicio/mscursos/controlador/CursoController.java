package com.servicio.mscursos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.mscursos.entidades.Curso;
import com.servicio.mscursos.modelos.Calificacion;
import com.servicio.mscursos.modelos.Inscripcion;
import com.servicio.mscursos.servicio.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoService.getCursos();
        
        if (cursos.isEmpty()){
            return ResponseEntity.noContent().build();
        } 
        
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<Curso> obtenerCurso(@PathVariable("id") int id) {
        Curso curso = cursoService.getCursoPorId(id);

        if (curso == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(curso);
    }

    @PostMapping("crear")
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crearCurso(curso);
        return ResponseEntity.ok(nuevoCurso);
    }

    @GetMapping("/calificaciones/{idCurso}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesDelCurso(@PathVariable("idCurso") int id) {
        Curso curso = cursoService.getCursoPorId(id);

        if (curso == null) {
            return ResponseEntity.notFound().build();
        }

        List<Calificacion> calificaciones = cursoService.getCalificacionesDelCurso(id);
        return ResponseEntity.ok(calificaciones);
    }

    @GetMapping("/inscripciones/{idCurso}")
    public ResponseEntity<List<Inscripcion>> listarInscripcionesDelCurso(@PathVariable("idCurso") int id) {
        Curso curso = cursoService.getCursoPorId(id);

        if (curso == null) {
            return ResponseEntity.notFound().build();
        }

        List<Inscripcion> inscripciones = cursoService.getInscripcionesDelCurso(id);
        return ResponseEntity.ok(inscripciones);
    }
}

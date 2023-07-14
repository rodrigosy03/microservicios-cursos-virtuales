package com.servicio.msinscripciones.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicio.msinscripciones.entidades.Inscripcion;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {
    List<Inscripcion> findByEstudianteId(int estudianteId);
    List<Inscripcion> findByCursoId(int cursoId);
}

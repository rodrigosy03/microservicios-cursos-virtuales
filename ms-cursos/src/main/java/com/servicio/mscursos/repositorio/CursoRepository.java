package com.servicio.mscursos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicio.mscursos.entidades.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}

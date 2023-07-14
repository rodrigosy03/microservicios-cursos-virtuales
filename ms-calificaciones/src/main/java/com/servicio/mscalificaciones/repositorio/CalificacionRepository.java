package com.servicio.mscalificaciones.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicio.mscalificaciones.entidades.Calificacion;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {
    List<Calificacion> getPorEstudiante(int idEstudiante);
    List<Calificacion> getPorCurso(int idCurso);
}
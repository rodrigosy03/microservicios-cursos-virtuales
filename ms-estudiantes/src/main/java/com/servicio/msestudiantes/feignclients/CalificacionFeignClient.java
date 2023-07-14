package com.servicio.msestudiantes.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servicio.msestudiantes.modelos.Calificacion;

@FeignClient(name = "ms-calificaciones", url = "http://localhost:5003")
@RequestMapping("/calificaciones")
public interface CalificacionFeignClient {
	@PostMapping("/crear")
    public Calificacion crear(@RequestBody Calificacion calificacion);
}

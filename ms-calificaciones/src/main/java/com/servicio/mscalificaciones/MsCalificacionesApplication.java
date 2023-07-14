package com.servicio.mscalificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsCalificacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCalificacionesApplication.class, args);
	}

}

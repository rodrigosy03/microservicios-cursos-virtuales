package com.servicio.msestudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class MsEstudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEstudiantesApplication.class, args);
	}

}

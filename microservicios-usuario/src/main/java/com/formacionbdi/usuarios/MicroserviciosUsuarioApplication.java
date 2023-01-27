package com.formacionbdi.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.formacionbdi.commonsalumnos.models"})
public class MicroserviciosUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosUsuarioApplication.class, args);
	}

}

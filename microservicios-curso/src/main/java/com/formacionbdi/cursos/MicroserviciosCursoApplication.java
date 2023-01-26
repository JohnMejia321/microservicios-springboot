package com.formacionbdi.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviciosCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCursoApplication.class, args);
	}

}

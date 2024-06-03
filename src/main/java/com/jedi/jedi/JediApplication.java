package com.jedi.jedi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JediApplication {

	//TODO FAZER VALIDAÇÕES
	//TODO COMO COLOCAR SPRING BOOT NO DOCKER
	public static void main(String[] args) {
		SpringApplication.run(JediApplication.class, args);
	}
}
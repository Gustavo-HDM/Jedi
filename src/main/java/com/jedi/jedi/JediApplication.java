package com.jedi.jedi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JediApplication {

	//TODO FAZER VALIDAÇÕES
	//TODO FAZER DTO DO RESULTADO DO POSTMAN (SERVICE, RETORNAR NO CONTROLLER)
	//TODO FAZER UM SERVIÇO DE PAGAMENTO (LIMITAR SE NÃO TIVER PAGO)
	//TODO checar: OneToOne obriga o lightsaber ser registrado a apenas 1 jedi
	public static void main(String[] args) {
		SpringApplication.run(JediApplication.class, args);
	}
}
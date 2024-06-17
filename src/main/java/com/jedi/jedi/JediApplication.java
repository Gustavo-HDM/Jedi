package com.jedi.jedi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JediApplication {

	//TODO FAZER VALIDAÇÕES
	//TODO FAZER UM SERVIÇO DE PAGAMENTO (LIMITAR SE NÃO TIVER PAGO)
	//TODO checar: OneToOne obriga o lightsaber ser registrado a apenas 1 jedi
	//TODO aplicar ResponseDTO e filtragem de user no GetAll
	//TODO criar novo usuario
	//TODO aplicar SWAGGER
	//TODO estudar chamadas HTTP
	//TODO retornar mensalidade de String para objeto
	public static void main(String[] args) {
		SpringApplication.run(JediApplication.class, args);
	}
}
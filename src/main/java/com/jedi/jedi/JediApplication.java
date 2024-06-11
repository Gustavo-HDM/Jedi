package com.jedi.jedi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JediApplication {

	//TODO FAZER VALIDAÇÕES
	//TODO Saber como armazenar o usuario acessado em uma variavel
	//TODO FAZER DTO DO RESULTADO DO POSTMAN (SERVICE, RETORNAR NO CONTROLLER)
	//TODO FAZER MAPEAMENTO DOS OUTROS (ADICIONAR O USER, O MESMO QUE NO JEDI)
	//TODO FAZER UM SERVIÇO DE PAGAMENTO (LIMITAR SE NÃO TIVER PAGO)
	public static void main(String[] args) {
		SpringApplication.run(JediApplication.class, args);
	}
}
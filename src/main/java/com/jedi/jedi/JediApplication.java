package com.jedi.jedi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JediApplication {

	//TODO FAZER UM SERVIÇO DE PAGAMENTO (LIMITAR SE NÃO TIVER PAGO)
	//TODO aplicar ResponseDTO e filtragem de user no GetAll
	//TODO VER SOBRE SWAGGER
	//TODO retornar mensalidade de String para objeto (MUDAR RETORNO DO METODO)
	//TODO DIFICULDADES EM COLOCAR PROJETO PAGAMENTO NO DOCKER...
	//TODO FAZER O GETALL COM O USER IGUAL AO FEITO NO JEDI
	public static void main(String[] args) {
		SpringApplication.run(JediApplication.class, args);
	}
}
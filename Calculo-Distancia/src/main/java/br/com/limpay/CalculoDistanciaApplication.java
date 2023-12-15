package br.com.limpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculoDistanciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculoDistanciaApplication.class, args);
		System.out.println("API para calculo de distancia rodando!");
	}

}

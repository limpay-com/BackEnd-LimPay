package br.com.limpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FazendoALimpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(FazendoALimpaApplication.class, args);
		System.out.println("Cursos e videos online, API Rodando!");
	}

}

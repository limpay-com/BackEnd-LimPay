package br.com.limpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndLimPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndLimPayApplication.class, args);
		System.out.println("API Rodando!");
	}

}

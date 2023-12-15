package br.com.limpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiParaSimularPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiParaSimularPagamentoApplication.class, args);
		System.out.println("API de Pagamento Rodando!");
	}
}

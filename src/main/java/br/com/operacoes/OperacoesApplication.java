package br.com.operacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "br.com.operacoes.core.repository")
@SpringBootApplication
public class OperacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperacoesApplication.class, args);
	}

}

package com.projeto.diasjuntos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //habilita o agendamento de tarefas para atualizar o contador
public class DiasjuntosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiasjuntosApplication.class, args);
	}

}

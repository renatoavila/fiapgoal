package com.fiap.goal;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fiap.goal.business.ContaBusiness;
import com.fiap.goal.models.Conta;
import com.fiap.goal.models.Pessoa;

@SpringBootApplication
public class GoalApplication {

	public static void main(String[] args) {
 
		SpringApplication.run(GoalApplication.class, args);
	}
	
	 
}

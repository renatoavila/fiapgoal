package com.fiap.goal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fiap.goal.business.ContaBusiness;
import com.fiap.goal.models.Conta;
import com.fiap.goal.models.Pessoa;

@SpringBootTest
class GoalApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void Tela1() {
		  
		  ContaBusiness contaBusiness = new ContaBusiness();
		  Pessoa pessoa = new Pessoa("renato");
		  Conta conta = new Conta("123", "456", pessoa);		   
		  contaBusiness.criarConta(conta);

 
	}
	 
}

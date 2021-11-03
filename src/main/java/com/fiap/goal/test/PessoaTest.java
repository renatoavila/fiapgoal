package com.fiap.goal.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiap.goal.business.ContaBusiness;
import com.fiap.goal.models.Conta;
import com.fiap.goal.models.Pessoa;
import com.fiap.goal.repository.PessoaRepository;

public class PessoaTest {
	
	@Autowired
	PessoaRepository pessoaRepository;
	 
	public void Tela1() {
		  
		Pessoa pessoa = new Pessoa("renato");
		pessoaRepository.save(pessoa);
 
	}
	 
}

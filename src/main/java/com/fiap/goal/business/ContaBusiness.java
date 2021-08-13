package com.fiap.goal.business;

import com.fiap.goal.models.*;
import com.fiap.goal.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
 

public class ContaBusiness {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	ContaRepository contaRepository;

	public void criarConta(Conta conta) {

		pessoaRepository.save(conta.getPessoa());
		contaRepository.save(conta);
		
	}
}

package com.fiap.goal.business;

import com.fiap.goal.models.*;
import com.fiap.goal.repository.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
 
@Service
public class ContaBusiness {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private  ContaRepository contaRepository;
	 
	public void criarConta(Conta conta, Pessoa pessoa) {

		pessoaRepository.save(pessoa);
		contaRepository.save(conta);
		
	}
	
	public Conta buscarConta(long idPessoa) {
		
		Pessoa pessoa = pessoaRepository.findById(idPessoa).orElse(null);
		if(pessoa != null) {
			Conta conta = contaRepository.findByPessoa(pessoa);		 
			return conta;
		}
		return null;		
	}
}

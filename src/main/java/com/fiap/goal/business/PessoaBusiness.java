package com.fiap.goal.business;

import com.fiap.goal.models.*;
import com.fiap.goal.repository.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
 
@Service
public class PessoaBusiness {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ContaBusiness contaBusiness;
	  
	public Pessoa buscaPessoa(long id) {

		Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
		
		return pessoa;
	}
	
	public Pessoa buscaPessoa(UsuarioViewModel usuario) {
		
		Pessoa pessoa = pessoaRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		
		return pessoa;		
	}
	
	public Pessoa buscaPessoa(Pessoa pessoa) {
		
		Pessoa pessoaAux = pessoaRepository.findByEmail(pessoa.getEmail());
		
		return pessoaAux;		
	}
	

	public Pessoa criarPessoa(Pessoa pessoa) {
		
		 pessoaRepository.save(pessoa);		 
		 contaBusiness.criarContaParaPessoa(pessoa);
		
		return pessoa;		
	}
	
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		
		 pessoaRepository.save(pessoa);		  
		return pessoa;		
	}
}

package com.fiap.goal.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.fiap.goal.models.Pessoa;
import com.fiap.goal.models.PessoaPromocao;
import com.fiap.goal.repository.PessoaPromocaoRepository;

@Service
public class PessoaPromocaoBusiness {

	@Autowired
	private PessoaPromocaoRepository pessoaPromocaoRepository;

	@Autowired
	private PessoaBusiness pessoaBusiness;
	
	public void criarPessoaPromocao(Pessoa pessoa, Double valor) {
		
		PessoaPromocao pessoaPromocao = new PessoaPromocao(pessoa, valor);
		pessoaPromocaoRepository.save(pessoaPromocao);

	}

	public PessoaPromocao usouPromocao(Pessoa pessoa)
	{
		return  pessoaPromocaoRepository.findByPessoa(pessoa);
	}
	
	public PessoaPromocao usouPromocao(long codigoPessoa)
	{
		Pessoa pessoa = pessoaBusiness.buscaPessoa(codigoPessoa);
		return  this.usouPromocao(pessoa);
	}
}
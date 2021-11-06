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
	private PessoaBusiness pessoaBusiness;

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private CofreBusiness cofreBusiness;
	
	@Autowired
	private PessoaPromocaoBusiness pessoaPromocaoBusiness;

	public void criarContaParaPessoa(Pessoa pessoa) {

		long numero_conta = contaRepository.count() + 10000;
		Conta conta = new Conta("0001", String.valueOf(numero_conta), 0.0, pessoa);
		contaRepository.save(conta);

	}
	 
	public void editarConta(Conta conta) {
		 contaRepository.save(conta);
	}


	public Conta buscarConta(long codigo) {
 
			Conta conta = contaRepository.findById(codigo).get();			 
			return conta;		 
	}
	
	public Conta buscarContaPorPessoa(long codigoPessoa, Boolean fazerSomaCofre) {

		Pessoa pessoa = pessoaBusiness.buscaPessoa(codigoPessoa);
		if (pessoa != null) {
			Conta conta = contaRepository.findByPessoa(pessoa);
			if (conta != null) {
				var cofre = cofreBusiness.buscarCofreDaConta(conta);
				
				if(fazerSomaCofre)
				{
					double soma = 0;
					for(int i = 0; i < cofre.size(); i++)
					{
						soma += cofre.get(i).getValorTotal();
					}
					conta.setSaldo(conta.getSaldo() + soma);
				}

				conta.setCofre(cofre);
			}
			return conta;
		}
		return null;
	}

	public Boolean depositarPromocao(long codigoPessoa, long codigoConta, Double valor) {
		
		
		PessoaPromocao pessoaPromocao =  pessoaPromocaoBusiness.usouPromocao(codigoPessoa);
		
		if(pessoaPromocao != null)
		{
			return false;
		}
		
		Conta conta = contaRepository.findById(codigoConta).get();
		
		if(conta == null)
		{
			return false;
		}
		
		conta.setSaldo(conta.getSaldo() + valor);
		contaRepository.save(conta);
		 
		Pessoa pessoa = pessoaBusiness.buscaPessoa(codigoPessoa);
		pessoaPromocaoBusiness.criarPessoaPromocao(pessoa, valor);
	 
			
		return true;
		 
				
	}

}

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

	public void criarContaParaPessoa(Pessoa pessoa) {

		long numero_conta = contaRepository.count() + 10000;
		Conta conta = new Conta("0001", String.valueOf(numero_conta), 0.0, pessoa);
		contaRepository.save(conta);

	}

	public Conta buscarConta(long idPessoa) {

		Pessoa pessoa = pessoaBusiness.buscaPessoa(idPessoa);
		if (pessoa != null) {
			Conta conta = contaRepository.findByPessoa(pessoa);
			if (conta != null) {
				var cofre = cofreBusiness.buscarCofreDaConta(conta);
				conta.setCofre(cofre);
			}
			return conta;
		}
		return null;
	}
}

package com.fiap.goal.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.fiap.goal.models.Conta;
import com.fiap.goal.models.Pessoa;

@EnableJpaRepositories
public interface ContaRepository extends CrudRepository<Conta, Long> {

	Conta findByPessoa(Pessoa pessoa);
}

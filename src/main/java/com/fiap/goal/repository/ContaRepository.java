package com.fiap.goal.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.fiap.goal.models.Conta;

@EnableJpaRepositories
public interface ContaRepository extends CrudRepository<Conta, Long> {

}

package com.fiap.goal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.fiap.goal.models.Cofre;
import com.fiap.goal.models.Conta;
import com.fiap.goal.models.Pessoa;

 
@EnableJpaRepositories
public interface CofreRepository extends CrudRepository<Cofre, Long> {
	List<Cofre> findByConta(Conta conta); 

}

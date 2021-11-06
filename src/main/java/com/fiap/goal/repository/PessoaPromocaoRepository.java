package com.fiap.goal.repository;
 
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.fiap.goal.models.Pessoa;
import com.fiap.goal.models.PessoaPromocao;

 
@EnableJpaRepositories
public interface PessoaPromocaoRepository  extends CrudRepository<PessoaPromocao, Long> {

	PessoaPromocao findByPessoa(Pessoa pessoa); 
}

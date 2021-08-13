package com.fiap.goal.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.fiap.goal.models.CofreHistorico;

 
@EnableJpaRepositories
public interface CofreHistoricoRepository extends CrudRepository<CofreHistorico, Long> {

}

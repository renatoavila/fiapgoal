package com.fiap.goal.business;

import com.fiap.goal.models.*;
import com.fiap.goal.repository.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
 

public class CofreBusiness {
 
	@Test
	public void Tela1() {
		  
		  ContaBusiness contaBusiness = new ContaBusiness();
		  Pessoa pessoa = new Pessoa("renato");
		  Conta conta = new Conta("123", "456", pessoa);		   
		  contaBusiness.criarConta(conta);

 
	}
	@Autowired
	CofreRepository cofreRepository;
	
	@Autowired
	CofreHistoricoRepository cofreHistoricoRepository;

	public void criarCofre(Cofre cofre) { 
		cofreRepository.save(cofre);
	}
	
	public void editarCofre(Cofre cofre) { 
		cofreRepository.save(cofre);
	}
	  
	public Optional<Cofre> buscarCofre(long Codigo) { 
		return cofreRepository.findById(Codigo);
	}
	
	public void depositarCofre(Cofre cofre, double valor) {
	 
		cofre.setValorTotal(cofre.getValorTotal() + valor);
		cofreRepository.save(cofre);
		
		CofreHistorico cofreHistorico = new CofreHistorico(valor, cofre);
		cofreHistoricoRepository.save(cofreHistorico);
	}
	
	public Boolean resgatarCofre(Cofre cofre, double valor) {
		 
		cofre.setValorTotal(cofre.getValorTotal() - valor);
		
		if(cofre.getValorTotal() > 0)
		{		
			cofreRepository.save(cofre);
			
			CofreHistorico cofreHistorico = new CofreHistorico(- valor, cofre);
			cofreHistoricoRepository.save(cofreHistorico);
			
			return true;
			
		}else {
			
			return false;
		}
	}
	
}

package com.fiap.goal.business;

import com.fiap.goal.models.*;
import com.fiap.goal.repository.*;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class CofreBusiness {
 
	

	@Autowired
	CofreRepository cofreRepository;
	

	@Autowired
	ContaBusiness contaBusiness;
	
	@Autowired
	CofreHistoricoRepository cofreHistoricoRepository;

	public void criarCofre(Cofre cofre) { 
		Conta conta = contaBusiness.buscarConta(cofre.getConta().getCodigo());
		cofreRepository.save(cofre);
	}
	
	public void editarCofre(Cofre cofre) { 
		cofreRepository.save(cofre);
	}
	
	public List<Cofre> buscarCofreDaConta(Conta conta) { 
		return this.cofreRepository.findByConta(conta);
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
		
		if(cofre.getValorTotal() >= 0)
		{		
			cofreRepository.save(cofre);
			
			CofreHistorico cofreHistorico = new CofreHistorico(-valor, cofre);
			cofreHistoricoRepository.save(cofreHistorico);
			
			return true;
			
		}else {
			
			return false;
		}
	}
	
}

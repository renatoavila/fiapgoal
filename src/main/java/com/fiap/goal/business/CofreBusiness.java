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

	public Boolean criarCofre(Cofre cofre) { 
		Conta conta = contaBusiness.buscarConta(cofre.getConta().getCodigo());
		conta.setSaldo(conta.getSaldo() - cofre.getValorTotal());
		if(conta.getSaldo() >= 0)
		{
			contaBusiness.editarConta(conta);
			cofreRepository.save(cofre);
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean editarCofre(Cofre cofre) { 
		Cofre cofreAnterior = this.buscarCofre(cofre.getCodigo()).get();
		Conta conta = contaBusiness.buscarConta(cofre.getConta().getCodigo());	
		Double diferenca =  cofreAnterior.getValorTotal() - cofre.getValorTotal();
		conta.setSaldo(conta.getSaldo() + diferenca);
		if(conta.getSaldo() >= 0)
		{
			contaBusiness.editarConta(conta);
			cofreRepository.save(cofre);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean deletarCofre(int codigoPessoa, int codigoCofre) { 
		
		Conta contaTemp = contaBusiness.buscarContaPorPessoa(codigoPessoa, false);	  
		Conta conta = contaBusiness.buscarConta(contaTemp.getCodigo());	
		Cofre cofre = this.buscarCofre(codigoCofre).get();
		conta.setSaldo(conta.getSaldo() + cofre.getValorTotal() );
		if(conta.getSaldo() >= 0)
		{
			cofre.setConta(conta);
			contaBusiness.editarConta(conta);
			cofreRepository.delete(cofre);
			return true;
		}
		else {
			return false;
		}
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

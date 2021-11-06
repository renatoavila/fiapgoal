package com.fiap.goal.business;

import com.fiap.goal.models.*;
import com.fiap.goal.repository.*;

import java.util.ArrayList;
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
		conta.setSaldoLivre(conta.getSaldoLivre() - cofre.getValorTotal());
		if(conta.getSaldoLivre() >= 0)
		{
			cofre.setIsDeletado(false);
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
		conta.setSaldoLivre(conta.getSaldoLivre() + diferenca);
		if(conta.getSaldoLivre() >= 0)
		{
			cofre.setIsDeletado(false);
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
		conta.setSaldoLivre(conta.getSaldoLivre() + cofre.getValorTotal() );
		if(conta.getSaldoLivre() >= 0)
		{
			cofre.setConta(conta);
			contaBusiness.editarConta(conta);
			cofre.setIsDeletado(true);
			cofreRepository.save(cofre);
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Cofre> buscarCofreDaConta(Conta conta) { 
		 List<Cofre> listCofre =  this.cofreRepository.findByConta(conta);
		 ArrayList<Cofre> listCofreRetorno = new ArrayList<>();
		 for(int i = 0; i < listCofre.size(); i++)
		{ 
			if(!listCofre.get(i).getIsDeletado()) 
			{
				listCofreRetorno.add(listCofre.get(i));
			}
			 
			 
		} 
		 return listCofreRetorno;
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

package com.fiap.goal.models;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
 

@Entity
public class Conta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private long codigo;
	 
	private String agencia;
	private String numero;
	private Double saldoLivre;
	@Transient
	private Double saldoTotal;
	@OneToOne
	@JsonIgnore
	private Pessoa pessoa;	
	@OneToMany
	private List<Cofre> cofre;
	
	
	public Conta() {
		super(); 
	}
	
	public Conta(String agencia, String numero, Double saldoLivre, Pessoa pessoa) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.saldoLivre = saldoLivre;
		this.pessoa = pessoa;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<Cofre> getCofre() {
		return cofre;
	}
	public void setCofre(List<Cofre> cofre) {
		this.cofre = cofre;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldoLivre() {
		return saldoLivre;
	}

	public void setSaldoLivre(Double saldo) {
		this.saldoLivre = saldo;
	}
	

	public Double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(Double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}
	
	
	
}

package com.fiap.goal.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CofreHistorico  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private long codigo;	 
	private Date operacao;
	private double valor;
	 
	@ManyToOne
	private Cofre cofre;
	 
	public Cofre getCofre() {
		return cofre;
	}
	public void setCofre(Cofre cofre) {
		this.cofre = cofre;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
 
	public Date getOperacao() {
		return operacao;
	}

	public void setOperacao(Date operacao) {
		this.operacao = operacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}

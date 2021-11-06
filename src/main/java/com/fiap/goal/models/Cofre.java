package com.fiap.goal.models;

import java.util.List;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cofre implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private long codigo;
	 
	private String nome;
	private String descricaoMeta;

    @JsonIgnore
	private Date cadastro;
	private Date vencimentoMeta;
    private double valorTotal;
    private double valorMeta;
    private Boolean isDeletado;
 
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Conta conta;
    
    @OneToMany
    @JsonIgnore
    private List<CofreHistorico> cofreHistorico;
    
    public Cofre() {
    	super();
    }
	
	public Cofre(String nome, String descricaoMeta, Date cadastro, Date vencimentoMeta,double valorMeta,double valorTotal, Conta conta) {
		super();
		this.nome = nome;
		this.descricaoMeta = descricaoMeta;
		this.vencimentoMeta = vencimentoMeta;
		this.valorMeta = valorMeta;
		this.valorTotal = valorTotal;
		this.conta = conta;
		this.cadastro = cadastro;
		this.isDeletado = false;
	}
	
	public Cofre(long codigo, String nome, String descricaoMeta,Date cadastro, Date vencimentoMeta,  double valorMeta,  double valorTotal, Conta conta) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricaoMeta = descricaoMeta;
		this.vencimentoMeta = vencimentoMeta;
		this.valorTotal = valorTotal;
		this.cadastro = cadastro;
		this.valorMeta = valorMeta;
		this.conta = conta;
		this.isDeletado = false;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricaoMeta() {
		return descricaoMeta;
	}
	public void setDescricaoMeta(String descricaoMeta) {
		this.descricaoMeta = descricaoMeta;
	}
	public Date getCadastro() {
		return cadastro;
	}
	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}
	public Date getVencimentoMeta() {
		return vencimentoMeta;
	}
	public void setVencimentoMeta(Date vencimentoMeta) {
		this.vencimentoMeta = vencimentoMeta;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorMeta() {
		return valorMeta;
	}
	public void setValorMeta(double valorMeta) {
		this.valorMeta = valorMeta;
	}
	public List<CofreHistorico> getCofreHistorico() {
		return cofreHistorico;
	}
	public void setCofreHistorico(List<CofreHistorico> cofreHistorico) {
		this.cofreHistorico = cofreHistorico;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
    
	public Boolean getIsDeletado() {
		return isDeletado;
	}
	public void setIsDeletado(Boolean IsDeletado) {
		this.isDeletado = IsDeletado;
	}
    
}

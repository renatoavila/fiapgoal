package com.fiap.goal.models;

import java.sql.Date;

public class CofreViewModel{

	private String nome;
	private String descricaoMeta;
	private Date cadastro;
	private Date vencimentoMeta;
    private double valorTotal;
    private double valorMeta;
    
    public CofreViewModel() {
    	super();
    }
	
	public CofreViewModel(String nome, String descricaoMeta, Date vencimentoMeta, double valorMeta, double valorTotal, Conta conta) {
		super();
		this.nome = nome;
		this.descricaoMeta = descricaoMeta;
		this.vencimentoMeta = vencimentoMeta;
		this.valorMeta = valorMeta;
		this.valorTotal = valorTotal;
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
}

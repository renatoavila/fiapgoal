package com.fiap.goal.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore; 

@Entity
public class Pessoa implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private long codigo;

    private String nome; 
    
    private String email; 
    
    @JsonIgnore
    private String senha; 
    
    @OneToOne
    private Conta conta;
    
    public Pessoa() {
    	super();
    }
    
    public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

    public Pessoa(String nome, String email, String senha ) {
		super();
		this.nome = nome;
		this.email =email;
		this.senha =senha; 
	}
    

    public Pessoa(long codigo, String nome, String email, String senha ) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email =email;
		this.senha =senha; 
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

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
 
}

package com.fiap.goal.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.goal.models.*;
import com.fiap.goal.repository.*;
import com.google.gson.Gson;
import com.fiap.goal.business.*;

@RestController
public class PessoaController {

	@Autowired
	PessoaBusiness pessoaBusiness;

	@Autowired
	ContaBusiness contaBusiness;
	
	@Autowired
	CofreBusiness cofreBusiness;

	@RequestMapping(value = "api/pessoa/", method = RequestMethod.POST)
	public ResponseEntity<Pessoa> post(@RequestBody PessoaViewModel pessoaModel) {

		Log(pessoaModel);
		 
		Pessoa pessoa = new Pessoa(pessoaModel.getNome(), pessoaModel.getEmail(), pessoaModel.getSenha());

		pessoaBusiness.criarPessoa(pessoa);
		long id = pessoa.getCodigo();

		if (id > 0) {
			pessoa.setSenha("");
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "api/pessoa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pessoa> put(@PathVariable(value = "id") int id, @RequestBody PessoaViewModel pessoaModel) {
		Log(pessoaModel);
		
		Pessoa pessoa = new Pessoa(id, pessoaModel.getNome(), pessoaModel.getEmail(), pessoaModel.getSenha());

		pessoaBusiness.atualizarPessoa(pessoa);
		 
		if (id > 0) {
			pessoa.setSenha("");
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "api/pessoa/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pessoa> get(@PathVariable(value = "id") int id) {
		Log(id);
		Pessoa pessoa = pessoaBusiness.buscaPessoa(id);

		if (pessoa != null)
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "api/pessoa/{id}/conta/", method = RequestMethod.GET)
	public ResponseEntity<Conta> getPessoaConta(@PathVariable(value = "id") int id) {
		Log(id);
		Conta conta = contaBusiness.buscarConta(id);

		if (conta != null)
			return new ResponseEntity<Conta>(conta, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "api/pessoa/{id}/conta/cofre/", method = RequestMethod.POST)
	public ResponseEntity<Conta> postCofre(@PathVariable(value = "id") int id, @RequestBody CofreViewModel cofreModel) {
		Log(cofreModel);
		Conta conta = contaBusiness.buscarConta(id);
		Cofre cofre = new Cofre(
				cofreModel.getNome(),
				cofreModel.getDescricaoMeta(),
				cofreModel.getCadastro(),
				cofreModel.getVencimentoMeta(),
				cofreModel.getValorMeta(),	
				conta				
				);
		 cofreBusiness.criarCofre(cofre);
		 return new ResponseEntity<>(HttpStatus.OK);
	}

	
	@RequestMapping(value = "api/pessoa/{id}/conta/cofre/{idCofre}", method = RequestMethod.PUT)
	public ResponseEntity<Cofre> putCofre(@PathVariable(value = "id") int id,@PathVariable(value = "idCofre") int idCofre,@RequestBody CofreViewModel cofreModel) {
		Log(cofreModel);
		Conta conta = contaBusiness.buscarConta(id);
		Cofre cofre = new Cofre(
				idCofre,
				cofreModel.getNome(),
				cofreModel.getDescricaoMeta(),
				cofreModel.getCadastro(),
				cofreModel.getVencimentoMeta(),
				cofreModel.getValorMeta(),	
				conta				
				);
		 cofreBusiness.criarCofre(cofre);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void Log(Object o) {
		Gson gson = new Gson();    
	    String json = gson.toJson(o);
	    System.out.println(json);
 }

}

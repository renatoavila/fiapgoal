package com.fiap.goal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.goal.models.*; 
import com.fiap.goal.repository.*; 
import com.fiap.goal.business.*;

@RestController
public class PessoaController {
 
	@Autowired
	ContaBusiness contaBusiness;
	
	 @RequestMapping(value = "api/pessoa/{id}/conta/", method = RequestMethod.GET)
	public  ResponseEntity<Conta> get(@PathVariable(value = "id") int id) {
		 
		 Pessoa p = new Pessoa("Renato");
		 Conta c = new Conta("0001","123456", 100.00,p);
		 contaBusiness.criarConta(c, p);
		 
		 Conta conta = contaBusiness.buscarConta(id);
		 
		 if(conta != null)
			 return new ResponseEntity<Conta>(conta, HttpStatus.OK);
	        else
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

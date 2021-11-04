package com.fiap.goal.controllers;

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
import com.fiap.goal.business.*;

@RestController
public class LoginController {
 
	@Autowired
	PessoaBusiness pessoaBusiness;
	
	 @RequestMapping(value = "api/login/", method = RequestMethod.POST)
	public  ResponseEntity<Pessoa> get(@RequestBody UsuarioViewModel usuario) {
		 
		 Pessoa pessoa = pessoaBusiness.buscaPessoa(usuario);
		 
		 if(pessoa != null)
		 {
			 pessoa.setSenha("");
			 return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
		 }
        else
        {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

}

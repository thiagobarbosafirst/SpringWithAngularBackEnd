package br.com.pbna.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pbna.entidade.Operacao;
import br.com.pbna.negocio.DepositoNegocio;

@RestController
@RequestMapping("/deposito")
public class DepositoRest {
	
	@Autowired
	private DepositoNegocio depositoNegocio;
	
	@PostMapping
	public ResponseEntity<?> incluir(@RequestBody Operacao deposito) {
		
		depositoNegocio.incluir(deposito);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

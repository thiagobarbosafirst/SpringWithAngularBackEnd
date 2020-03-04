package br.com.pbna.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pbna.entidade.Agencia;
import br.com.pbna.negocio.AgenciaNegocio;

@RestController
@RequestMapping("/agencia")
public class AgenciaRest {
	
	@Autowired
	private AgenciaNegocio agenciaNegocio;
	
	@GetMapping("/{id}")
	public ResponseEntity<Agencia> obterAgencia(@PathVariable("id") Long id) {
		return new ResponseEntity<>(agenciaNegocio.obter(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Agencia>> obterAgencias() {
		return new ResponseEntity<>(agenciaNegocio.obterAgencias(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> incluir(@RequestBody Agencia agencia) {
		agenciaNegocio.incluir(agencia);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> alterar(@RequestBody Agencia agencia) {
		agenciaNegocio.alterar(agencia);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
		
		agenciaNegocio.excluir(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}

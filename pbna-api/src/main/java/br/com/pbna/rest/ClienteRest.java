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

import br.com.pbna.entidade.Cliente;
import br.com.pbna.negocio.ClienteNegocio;

@RestController
@RequestMapping("/cliente")
public class ClienteRest {
	@Autowired
	private ClienteNegocio clienteNegocio;
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obterCliente(@PathVariable("id") Long id) {
		return new ResponseEntity<>(clienteNegocio.obter(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> obterClientes() {
		return new ResponseEntity<>(clienteNegocio.obterClientes(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> incluir(@RequestBody Cliente cliente) {
		clienteNegocio.incluir(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> alterar(@RequestBody Cliente cliente) {
		clienteNegocio.alterar(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
		
		clienteNegocio.excluir(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

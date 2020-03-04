package br.com.pbna.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pbna.dto.TransferenciaDTO;
import br.com.pbna.negocio.TransferenciaNegocio;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaRest {
	
	@Autowired
	private TransferenciaNegocio transferenciaNegocio;
	
	@PostMapping
	public ResponseEntity<?> incluir(@RequestBody TransferenciaDTO transferencia) {
		
		try {
			transferenciaNegocio.incluir(transferencia);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

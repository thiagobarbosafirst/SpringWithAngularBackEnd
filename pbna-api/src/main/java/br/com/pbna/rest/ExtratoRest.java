package br.com.pbna.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pbna.entidade.Operacao;
import br.com.pbna.entidade.pk.ContaPK;
import br.com.pbna.negocio.ContaNegocio;
import br.com.pbna.negocio.ExtratoNegocio;


@RestController
@RequestMapping("/extrato")
public class ExtratoRest {
	
	@Autowired
	private ExtratoNegocio extratoNegocio;
	
	@Autowired
	private ContaNegocio contaNegocio;

	@GetMapping(value = "/{id}/{tipoConta}")
	public ResponseEntity<List<Operacao>> oberExtrato(@PathVariable("id") Long id, @PathVariable("tipoConta") Long tipoConta) {
		
		return new ResponseEntity<>(extratoNegocio.obterOperacoesPorChavePrimaria(new ContaPK(id, tipoConta)), HttpStatus.OK);
	}
	
	@GetMapping("/obter-valor-conta/{id}/{tipoConta}")
	public ResponseEntity<BigDecimal> obterValorContaPorChavePrimaria(@PathVariable("id") Long id, @PathVariable("tipoConta") Long tipoConta) {
		
		return new ResponseEntity<>(contaNegocio.obterValorContaPorChavePrimaria(new ContaPK(id, tipoConta)), HttpStatus.OK);
	}
}


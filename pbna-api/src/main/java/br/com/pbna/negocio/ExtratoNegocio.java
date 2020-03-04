package br.com.pbna.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pbna.entidade.Conta;
import br.com.pbna.entidade.Operacao;
import br.com.pbna.entidade.pk.ContaPK;
import br.com.pbna.repositories.OperacaoRepository;

@Service("extratoNegocio")
public class ExtratoNegocio {
	
	@Autowired
	private OperacaoRepository operacaoRepository;
	
	public List<Operacao> obterOperacoesPorChavePrimaria(ContaPK contaPK) {
		return operacaoRepository.findByConta(new Conta(contaPK));
	}
}

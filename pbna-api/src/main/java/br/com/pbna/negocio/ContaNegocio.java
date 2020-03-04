package br.com.pbna.negocio;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pbna.entidade.Conta;
import br.com.pbna.entidade.pk.ContaPK;
import br.com.pbna.enums.TipoContaEnum;
import br.com.pbna.repositories.ContaRepository;

@Service("contaNegocio")
public class ContaNegocio {

	@Autowired
	private ContaRepository contaRepository;
	
	public Conta obterConta(ContaPK conta) {
		return this.contaRepository.findByChavePrimaria(conta);
	}
	
	public List<Conta> contas() {
		return contaRepository.findAll();
	}
	
	public List<Conta> contasTipoPoupanca() {
		return contaRepository.findByChavePrimaria_tipoConta(TipoContaEnum.POUPANCA);
	}
	
	public BigDecimal obterValorContaPorChavePrimaria(ContaPK chavePrimaria) {
		return this.contaRepository.obterValorContaPorChavePrimaria(chavePrimaria);
	}
	
	public void atualizarValorConta(BigDecimal valor, ContaPK chavePrimaria) {
		this.contaRepository.atualizarValorConta(valor, chavePrimaria);
	}
	
	public void atualizarTipoConta(TipoContaEnum tipoConta, ContaPK chavePrimaria) {
		this.contaRepository.atualizarTipoConta(tipoConta, chavePrimaria);
	}
	
	public Long gerarNumeroSequencial() {
		return contaRepository.gerarNumeroSequencial();
	}
	
	@Transactional
	public void incluir(List<Conta> contas) {
		this.contaRepository.saveAll(contas);
	}

}

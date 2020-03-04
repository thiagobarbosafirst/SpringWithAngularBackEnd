package br.com.pbna.negocio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.pbna.entidade.Conta;
import br.com.pbna.entidade.Operacao;
import br.com.pbna.enums.TipoOperacaoEnum;
import br.com.pbna.enums.TipoTransacaoEnum;
import br.com.pbna.repositories.OperacaoRepository;

@Service("rendimentoPoupancaNegocio")
public class RendimentoPoupancaNegocio {

	@Autowired
	private OperacaoRepository operacaoRepository;
	
	@Autowired
	private ContaNegocio contaNegocio;
	
	public List<Operacao> operacoes() {
		return this.operacaoRepository.findAll();
	}
	
	@Transactional
	public void incluir(Operacao operacao) {
		this.operacaoRepository.save(operacao);
	}
	
	@Transactional
	public void gerarOperacaoRendimento(Conta conta, BigDecimal valorTotalRendimento) {
		Operacao operacao = new Operacao();
		operacao.setConta(conta);
		operacao.setData(new Date());
		operacao.setSaldoConta(valorTotalRendimento);
		operacao.setTipoOperacao(TipoOperacaoEnum.RENDIMENTO_POUPANCA);
		operacao.setTipoTransacao(TipoTransacaoEnum.CREDITO);
		operacao.setValor(conta.getValor().multiply(new BigDecimal("0.01")));
		
		this.incluir(operacao);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void gerarRendimentos() {
		List<Conta> contasTipoPoupanca = contaNegocio.contasTipoPoupanca();
		
		contasTipoPoupanca.forEach(conta -> {
			BigDecimal valorTotalRendimento = conta.getValor().multiply(new BigDecimal("1.01"));
			
			this.gerarOperacaoRendimento(conta, valorTotalRendimento);
			contaNegocio.atualizarValorConta(valorTotalRendimento, conta.getChavePrimaria());
		});
	}
	
}




package br.com.pbna.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.pbna.entidade.Conta;
import br.com.pbna.entidade.Operacao;
import br.com.pbna.enums.TipoOperacaoEnum;
import br.com.pbna.enums.TipoTransacaoEnum;

public class TransferenciaDTO {
	
	private Conta contaOrigem;
	private Conta contaDestino;
	private BigDecimal valor;
	
	public Conta getContaOrigem() {
		return contaOrigem;
	}
	
	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	
	public Conta getContaDestino() {
		return contaDestino;
	}
	
	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public List<Operacao> createOperacoesTransferencia(TransferenciaDTO transferenciaDTO, BigDecimal valorContaOrigem,  BigDecimal valorContaDestino) {
		List<Operacao> operacoes = new ArrayList<Operacao>();
		operacoes.add(createOperacaoOrigem(transferenciaDTO, valorContaOrigem));
		operacoes.add(createOperacaoDestino(transferenciaDTO, valorContaDestino));
				
		return operacoes;
		
	}
	
	private Operacao createOperacaoDestino(TransferenciaDTO transferenciaDTO, BigDecimal valorContaDestino) {
		
		Operacao operacao = new Operacao();
		
		operacao.setConta(transferenciaDTO.getContaDestino());
		operacao.setTipoOperacao(TipoOperacaoEnum.TRANSFERENCIA);
		operacao.setTipoTransacao(TipoTransacaoEnum.CREDITO);
		operacao.setValor(transferenciaDTO.getValor());
		operacao.setSaldoConta(valorContaDestino.add(transferenciaDTO.getValor()));
		
		return operacao;
    }
	
	private Operacao createOperacaoOrigem(TransferenciaDTO transferenciaDTO, BigDecimal valorContaOrigem) {
			
		Operacao operacao = new Operacao();
		
		operacao.setConta(transferenciaDTO.getContaOrigem());
		operacao.setTipoOperacao(TipoOperacaoEnum.TRANSFERENCIA);
		operacao.setTipoTransacao(TipoTransacaoEnum.DEBITO);
		operacao.setSaldoConta(valorContaOrigem.subtract(transferenciaDTO.getValor()));
		operacao.setValor(transferenciaDTO.getValor());
		return operacao;
    }
	

}

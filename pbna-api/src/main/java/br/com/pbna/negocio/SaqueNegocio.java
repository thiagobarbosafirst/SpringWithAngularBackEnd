package br.com.pbna.negocio;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pbna.entidade.Operacao;
import br.com.pbna.enums.TipoOperacaoEnum;
import br.com.pbna.enums.TipoTransacaoEnum;
import br.com.pbna.repositories.SaqueRepository;

@Service("saqueNegocio")
public class SaqueNegocio {
	
	@Autowired
	private SaqueRepository saqueRepository;
	
	@Autowired
	private ContaNegocio contaNegocio;
	

	@Transactional
	public void incluir(Operacao saque) {
		
		saque.setTipoOperacao(TipoOperacaoEnum.SAQUE);
		saque.setTipoTransacao(TipoTransacaoEnum.DEBITO);
		
		BigDecimal valorConta = this.contaNegocio.obterValorContaPorChavePrimaria(saque.getConta().getChavePrimaria());
		
		if (valorConta != null && valorConta.compareTo(saque.getValor()) >= 0) {
			
			BigDecimal valorAtualizado = valorConta.subtract(saque.getValor());
			this.contaNegocio.atualizarValorConta(valorAtualizado, saque.getConta().getChavePrimaria());
			saque.setSaldoConta(valorAtualizado);
			
			this.saqueRepository.save(saque);
		} else {
			throw new IllegalStateException("Saldo da conta não é suficiente.");
		}
	}
	
	@Transactional
	public void alterar(Operacao saque) {
		this.saqueRepository.save(saque);
	}
	
	@Transactional
	public void excluir(Long id) {
		this.saqueRepository.deleteById(id);
	}

}

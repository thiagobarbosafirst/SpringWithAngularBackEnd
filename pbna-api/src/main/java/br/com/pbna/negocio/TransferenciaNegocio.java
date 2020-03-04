package br.com.pbna.negocio;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pbna.dto.TransferenciaDTO;
import br.com.pbna.repositories.TransferenciaRepository;

@Service("transferenciaNegocio")
public class TransferenciaNegocio {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Autowired
	private ContaNegocio contaNegocio;
	
	@Transactional
	public void incluir(TransferenciaDTO transferencia) {
		BigDecimal valorContaeOrigem = this.contaNegocio.obterValorContaPorChavePrimaria(transferencia.getContaOrigem().getChavePrimaria());
		BigDecimal valorContaDestino = this.contaNegocio.obterValorContaPorChavePrimaria(transferencia.getContaDestino().getChavePrimaria());
		
		if (valorContaeOrigem != null && valorContaeOrigem.compareTo(transferencia.getValor()) >= 0) {
			
			this.contaNegocio.atualizarValorConta(valorContaeOrigem.subtract(transferencia.getValor()), transferencia.getContaOrigem().getChavePrimaria());
			this.contaNegocio.atualizarValorConta(valorContaDestino.add(transferencia.getValor()), transferencia.getContaDestino().getChavePrimaria());
			
			this.transferenciaRepository.saveAll(transferencia.createOperacoesTransferencia(transferencia, valorContaeOrigem, valorContaDestino));
		} else {
			throw new IllegalStateException("Saldo da conta não é suficiente.");
		}
		
	}
	
}

package br.com.pbna.negocio;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pbna.entidade.Operacao;
import br.com.pbna.enums.TipoOperacaoEnum;
import br.com.pbna.enums.TipoTransacaoEnum;
import br.com.pbna.repositories.DepositoRepository;

@Service("depositoNegocio")
public class DepositoNegocio {
	
	@Autowired
	private DepositoRepository depositoRepository;
	
	@Autowired
	private ContaNegocio contaNegocio;
	
	@Transactional
	public void incluir(Operacao deposito) {
		deposito.setTipoOperacao(TipoOperacaoEnum.DEPOSITO);
		deposito.setTipoTransacao(TipoTransacaoEnum.CREDITO);
		
		BigDecimal valor = contaNegocio.obterValorContaPorChavePrimaria(deposito.getConta().getChavePrimaria());
		BigDecimal valorAtualizado = deposito.getValor();
		
		if  (valor != null) {
			valorAtualizado = valor.add(deposito.getValor());
		}
		deposito.setSaldoConta(valorAtualizado);
		this.contaNegocio.atualizarValorConta(valorAtualizado, deposito.getConta().getChavePrimaria());
		this.depositoRepository.save(deposito);
	}
	
	@Transactional
	public void alterar(Operacao deposito) {
		this.depositoRepository.save(deposito);
	}
	
	@Transactional
	public void excluir(Long id) {
		this.depositoRepository.deleteById(id);
	}

}

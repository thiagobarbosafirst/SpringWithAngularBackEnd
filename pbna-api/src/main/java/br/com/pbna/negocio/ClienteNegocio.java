package br.com.pbna.negocio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pbna.entidade.Cliente;
import br.com.pbna.entidade.Conta;
import br.com.pbna.repositories.ClienteRepository;

@Service("clienteNegocio")
public class ClienteNegocio {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContaNegocio contaNegocio;
	
	public Cliente obter(Long id) {
		return this.clienteRepository.findById(id).get();
	}

	public List<Cliente> obterClientes() {
		return clienteRepository.findAll();
	}
	
	@Transactional
	public void incluir(Cliente cliente) {
		List<Conta> contas = cliente.getContas();
		
		this.clienteRepository.save(cliente);
		
		contas.forEach(item -> {
			item.getChavePrimaria().setId(contaNegocio.gerarNumeroSequencial());
			item.setCliente(cliente);
		});
		this.contaNegocio.incluir(contas);
	}
	
	@Transactional
	public void alterar(Cliente cliente) {
		this.clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long id) {
		this.clienteRepository.deleteById(id);
	}

}

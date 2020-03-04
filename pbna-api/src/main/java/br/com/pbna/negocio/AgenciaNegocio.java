package br.com.pbna.negocio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pbna.entidade.Agencia;
import br.com.pbna.repositories.AgenciaRepository;

@Service("agenciaNegocio")
public class AgenciaNegocio {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	public Agencia obter(Long id) {
		return agenciaRepository.findById(id).get();
	}

	public List<Agencia> obterAgencias() {
		return agenciaRepository.findAll();
	}
	
	@Transactional
	public void incluir(Agencia agencia) {
		this.agenciaRepository.save(agencia);
	}
	
	@Transactional
	public void alterar(Agencia agencia) {
		this.agenciaRepository.save(agencia);
	}
	
	@Transactional
	public void excluir(Long id) {
		this.agenciaRepository.deleteById(id);
	}
}

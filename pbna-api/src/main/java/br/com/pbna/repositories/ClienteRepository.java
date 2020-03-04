package br.com.pbna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pbna.entidade.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	
}

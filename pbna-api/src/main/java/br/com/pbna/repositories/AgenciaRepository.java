package br.com.pbna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pbna.entidade.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}

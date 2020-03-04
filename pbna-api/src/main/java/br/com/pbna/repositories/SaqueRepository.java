package br.com.pbna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pbna.entidade.Operacao;

@Repository
public interface SaqueRepository extends JpaRepository<Operacao, Long> {
}

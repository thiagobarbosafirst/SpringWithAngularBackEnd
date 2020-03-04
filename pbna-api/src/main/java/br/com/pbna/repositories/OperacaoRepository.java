package br.com.pbna.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pbna.entidade.Conta;
import br.com.pbna.entidade.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

	List<Operacao> findByConta(Conta conta);

}


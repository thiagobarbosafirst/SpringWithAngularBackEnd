package br.com.pbna.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pbna.entidade.Conta;
import br.com.pbna.entidade.pk.ContaPK;
import br.com.pbna.enums.TipoContaEnum;

@Repository
public interface ContaRepository extends JpaRepository<Conta, ContaPK> {
	
	@Query(value = "select nextval('conta_id_seq')", nativeQuery = true)
    public Long gerarNumeroSequencial();

	@Query("select c.valor from Conta c where c.chavePrimaria = :chavePrimaria")
	BigDecimal obterValorContaPorChavePrimaria(@Param("chavePrimaria") ContaPK chavePrimaria);
	
	@Modifying
	@Query("update Conta c set c.valor = :valor where c.chavePrimaria = :chavePrimaria")
	void atualizarValorConta(@Param("valor") BigDecimal valor, @Param("chavePrimaria") ContaPK chavePrimaria);
	
	@Modifying
	@Query("update Conta c set c.chavePrimaria.tipoConta = :tipoConta where c.chavePrimaria = :chavePrimaria")
	void atualizarTipoConta(@Param("tipoConta") TipoContaEnum tipoConta, @Param("chavePrimaria") ContaPK chavePrimaria);
	
	List<Conta> findByChavePrimaria_tipoConta(TipoContaEnum tipoContaEnum);

	Conta findByChavePrimaria(ContaPK conta);
	
}

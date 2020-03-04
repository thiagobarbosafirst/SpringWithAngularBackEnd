package br.com.pbna.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.pbna.converter.TipoOperacaoConverter;
import br.com.pbna.converter.TipoTransacaoConverter;
import br.com.pbna.deserializer.TipoContaDeserializer;
import br.com.pbna.deserializer.TipoTransacaoDeserializer;
import br.com.pbna.enums.TipoOperacaoEnum;
import br.com.pbna.enums.TipoTransacaoEnum;
import br.com.pbna.serialize.TipoOperacaoSerializer;
import br.com.pbna.serialize.TipoTransacaoSerializer;

@Entity
@Table(name = "operacao")
public class Operacao extends SuperEntity<Long> {

	private static final long serialVersionUID = 6217271752661700394L;

	@Id 
	@SequenceGenerator(name = "sequencialOperacao", sequenceName = "operacao_id_seq", allocationSize = 1)	
    @GeneratedValue(generator = "sequencialOperacao")
    @Column(name = "id")
	private Long id;
    
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_conta"), @JoinColumn(name = "tipo_conta")})
    private Conta conta;
    
    @Column 
    private BigDecimal valor;   
    
    @Column 
    private BigDecimal saldoConta;   
    
    @Column
    @Convert(converter = TipoOperacaoConverter.class)
    @JsonSerialize(using = TipoOperacaoSerializer.class)
    @JsonDeserialize(using = TipoContaDeserializer.class)
    private TipoOperacaoEnum tipoOperacao;
    
    @Column
    @Convert(converter = TipoTransacaoConverter.class)
    @JsonSerialize(using = TipoTransacaoSerializer.class)
    @JsonDeserialize(using = TipoTransacaoDeserializer.class)
    private TipoTransacaoEnum tipoTransacao;
    
    @Column
    private Date data = new Date();

	@Override
	public Long getId() {
		return id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoOperacaoEnum getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacaoEnum tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoTransacaoEnum getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacaoEnum tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public BigDecimal getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(BigDecimal saldoConta) {
		this.saldoConta = saldoConta;
	}
	
}

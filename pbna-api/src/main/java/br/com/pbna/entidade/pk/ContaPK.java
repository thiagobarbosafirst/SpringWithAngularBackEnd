package br.com.pbna.entidade.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.pbna.converter.TipoContaConverter;
import br.com.pbna.deserializer.TipoContaDeserializer;
import br.com.pbna.enums.TipoContaEnum;
import br.com.pbna.serialize.TipoContaSerializer;

@Embeddable
public class ContaPK implements Serializable {

	private static final long serialVersionUID = 6217271752661700394L;

	private Long id;
	
    @Column
    @Convert(converter = TipoContaConverter.class)
    @JsonSerialize(using = TipoContaSerializer.class)
    @JsonDeserialize(using = TipoContaDeserializer.class)
    private TipoContaEnum tipoConta;
    
	public ContaPK(Long id, Long tipoConta) {
		super();
		this.id = id;
		this.tipoConta = TipoContaEnum.fromCodigo(tipoConta);
	}
	
	public ContaPK() {
	}

	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
}

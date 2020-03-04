package br.com.pbna.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.pbna.entidade.pk.ContaPK;

@Entity
@Table(name = "conta")
public class Conta extends SuperEntity<ContaPK> {

	private static final long serialVersionUID = 6217271752661700394L;

	@EmbeddedId
	private ContaPK chavePrimaria;
    
    @Column 
    private BigDecimal valor;      
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private Cliente cliente;
    
	public Conta(ContaPK chavePrimaria) {
		this.setChavePrimaria(chavePrimaria);
	}

	public Conta() {
	}

	public ContaPK getChavePrimaria() {
		return chavePrimaria;
	}

	public void setChavePrimaria(ContaPK chavePrimaria) {
		this.chavePrimaria = chavePrimaria;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public ContaPK getId() {
		return chavePrimaria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}

package br.com.pbna.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends SuperEntity<Long> {

	private static final long serialVersionUID = 6217271752661700394L;

	@Id 
	@Column(name = "id")
	@SequenceGenerator(name = "sequencialCliente", sequenceName = "cliente_id_seq", allocationSize = 1)	
    @GeneratedValue(generator = "sequencialCliente")
	private Long id;
	
    @Column(length = 300)
    private String nome;
    
    @Column(length = 20)
    private String cpf;
    
    @Column(length = 300)
    private String endereco;  
    
    @Column(length = 20)
    private String telefone;  
    
    @OneToMany(mappedBy = "cliente" )
    private List<Conta> contas;
    
    @ManyToOne
    @JoinColumn(name = "id_agencia")
    private Agencia agencia;
    
	public Cliente(Long id) {
		this.setId(id);
	}

	public Cliente() {
	}
	
	public Cliente(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}	
	
}

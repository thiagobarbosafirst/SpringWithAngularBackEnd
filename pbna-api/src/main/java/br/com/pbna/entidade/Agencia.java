package br.com.pbna.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "agencia")
public class Agencia extends SuperEntity<Long> {

	private static final long serialVersionUID = 6217271752661700394L;

	@Id 
	@Column(name = "id")
	@SequenceGenerator(name = "sequencialAgencia", sequenceName = "agencia_id_seq", allocationSize = 1)	
    @GeneratedValue(generator = "sequencialAgencia")
	private Long id;
	
    @Column(length = 300)
    private String nome;
    
    @Column(length = 100)
    private String apelido;
    
    @Column(length = 300)
    private String endereco;   
    
    
	public Agencia(Long id) {
		this.setId(id);
	}

	public Agencia() {
	}
	
	public Agencia(Long id, String nome) {
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

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
	
}

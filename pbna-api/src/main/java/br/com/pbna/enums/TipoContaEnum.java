package br.com.pbna.enums;

public enum TipoContaEnum {

	POUPANCA(1L, "Conta Poupança"),
	CORRENTE(2L, "Conta Corrente"),
	TODOS(3L, "TODOS");
	
	private final Long codigo;
	private final String nome;
	
	TipoContaEnum(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

	public Long getCodigo() {
		return codigo;
	}
	
	 public static TipoContaEnum fromCodigo(Long codigo) {
	    for(TipoContaEnum tipo : values()) {
    		if (tipo.getCodigo().equals(codigo)) {
    			return tipo;
    		}
    	}
    	return null;
    }
    
}

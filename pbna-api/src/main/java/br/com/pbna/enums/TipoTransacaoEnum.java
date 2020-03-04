package br.com.pbna.enums;

public enum TipoTransacaoEnum {

	CREDITO(1L, "Crédito"),
	DEBITO(2L, "Débito");
	
	private final Long codigo;
	private final String nome;
	
	TipoTransacaoEnum(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

	public Long getCodigo() {
		return codigo;
	}
	
	 public static TipoTransacaoEnum fromCodigo(Long codigo) {
	    for(TipoTransacaoEnum tipo : values()) {
    		if (tipo.getCodigo().equals(codigo)) {
    			return tipo;
    		}
    	}
    	return null;
    }
}

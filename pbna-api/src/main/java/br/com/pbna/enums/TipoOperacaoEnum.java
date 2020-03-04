package br.com.pbna.enums;

public enum TipoOperacaoEnum {
	
	DEPOSITO(1L, "Depósito"),
	SAQUE(2L, "Saque"),
	TRANSFERENCIA(3L, "Transferência"),
	RENDIMENTO_POUPANCA(4L, "Rendimento da Poupança");
	
	private final Long codigo;
	private final String nome;
	
	TipoOperacaoEnum(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

	public Long getCodigo() {
		return codigo;
	}
	
	 public static TipoOperacaoEnum fromCodigo(Long codigo) {
	    for(TipoOperacaoEnum tipo : values()) {
    		if (tipo.getCodigo().equals(codigo)) {
    			return tipo;
    		}
    	}
    	return null;
    }
}

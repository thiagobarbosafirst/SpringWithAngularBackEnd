package br.com.pbna.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import br.com.pbna.enums.TipoOperacaoEnum;

public class TipoTransacaoDeserializer extends JsonDeserializer<TipoOperacaoEnum> {

	@Override
	public TipoOperacaoEnum deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		Long codigo = p.getLongValue();
		
	    for (final TipoOperacaoEnum tipoConta : TipoOperacaoEnum.values()) {
	        if (tipoConta.getCodigo().equals(codigo)) {
	            return tipoConta;
	        }
	    }
	    return null;
	}

}
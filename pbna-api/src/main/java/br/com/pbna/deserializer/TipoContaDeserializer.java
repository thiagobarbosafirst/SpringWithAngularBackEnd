package br.com.pbna.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import br.com.pbna.enums.TipoContaEnum;

public class TipoContaDeserializer extends JsonDeserializer<TipoContaEnum> {

	@Override
	public TipoContaEnum deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		Long codigo = p.getLongValue();
		
	    for (final TipoContaEnum tipoConta : TipoContaEnum.values()) {
	        if (tipoConta.getCodigo().equals(codigo)) {
	            return tipoConta;
	        }
	    }
	    return null;
	}

}

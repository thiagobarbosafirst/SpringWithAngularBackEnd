package br.com.pbna.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.pbna.enums.TipoContaEnum;

public class TipoContaSerializer  extends JsonSerializer<TipoContaEnum> {

	@Override
	public void serialize(TipoContaEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("codigo", value.getCodigo());
		gen.writeStringField("nome", value.getNome());
		gen.writeEndObject();
	}
	
	

}

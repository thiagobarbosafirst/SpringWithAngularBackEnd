package br.com.pbna.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.pbna.enums.TipoOperacaoEnum;

public class TipoOperacaoSerializer  extends JsonSerializer<TipoOperacaoEnum> {

	@Override
	public void serialize(TipoOperacaoEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("codigo", value.getCodigo());
		gen.writeStringField("nome", value.getNome());
		gen.writeEndObject();
	}
	
	

}

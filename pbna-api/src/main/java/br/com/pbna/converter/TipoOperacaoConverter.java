package br.com.pbna.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.pbna.enums.TipoOperacaoEnum;

@Converter
public class TipoOperacaoConverter implements AttributeConverter<TipoOperacaoEnum, Long> {
	
	@Override
	public Long convertToDatabaseColumn(TipoOperacaoEnum attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCodigo();
	}

	@Override
	public TipoOperacaoEnum convertToEntityAttribute(Long dbData) {
		if (dbData == null) {
			return null;
		}
		return TipoOperacaoEnum.fromCodigo(dbData);
	}
	

}

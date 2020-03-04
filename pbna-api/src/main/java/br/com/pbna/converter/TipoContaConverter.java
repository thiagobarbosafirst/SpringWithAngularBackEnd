package br.com.pbna.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.pbna.enums.TipoContaEnum;

@Converter
public class TipoContaConverter implements AttributeConverter<TipoContaEnum, Long> {

	@Override
	public Long convertToDatabaseColumn(TipoContaEnum attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCodigo();
	}

	@Override
	public TipoContaEnum convertToEntityAttribute(Long dbData) {
		if (dbData == null) {
			return null;
		}
		return TipoContaEnum.fromCodigo(dbData);
	}
	

}

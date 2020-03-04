package br.com.pbna.converter;

import javax.persistence.AttributeConverter;

import br.com.pbna.enums.TipoTransacaoEnum;

public class TipoTransacaoConverter  implements AttributeConverter<TipoTransacaoEnum, Long> {
	
	@Override
	public Long convertToDatabaseColumn(TipoTransacaoEnum attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCodigo();
	}

	@Override
	public TipoTransacaoEnum convertToEntityAttribute(Long dbData) {
		if (dbData == null) {
			return null;
		}
		return TipoTransacaoEnum.fromCodigo(dbData);
	}
	

}
package adon.sample.helper;

import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ZonedDateTimeConverter implements
		AttributeConverter<ZonedDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(ZonedDateTime attribute) {
		if (attribute != null) {
			return Timestamp.from(attribute.toInstant());
		} else {
			return null;
		}
	}

	@Override
	public ZonedDateTime convertToEntityAttribute(Timestamp dbData) {
		if (dbData != null) {
			return ZonedDateTime.ofInstant(dbData.toInstant(),
					ZoneOffset.UTC);
		} else {
			return null;
		}
	}

}

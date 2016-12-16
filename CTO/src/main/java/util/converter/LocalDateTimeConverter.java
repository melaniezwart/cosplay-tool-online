package util.converter;

import org.joda.time.LocalDateTime;
import java.sql.Timestamp;

/**
 * Created by mzwart on 12-12-2016.
 */
public class LocalDateTimeConverter {
	/**
	 * Converteert een DateTime instantie naar een Timestamp instantie
	 * @param date De te converteren datum
	 * @return De geconverteerde timestamp. Of null, als de invoer null was
	 */
	@SuppressWarnings("deprecation")
	public Timestamp convertToDatabaseColumn(final LocalDateTime datetime) {
		if (datetime != null) {
			return new Timestamp(datetime.getYear() - 1900, datetime.getMonthOfYear()-1,
				datetime.getDayOfMonth(), datetime.getHourOfDay(), datetime.getMinuteOfHour(),
				datetime.getSecondOfMinute(), 0);
		}
		return null;
	}

	/**
	 * Converteert een Timestamp instantie naar een DateTime instantie
	 * @param date De te converteren datum
	 * @return De geconverteerde DateTime. Of null, als de invoer null was
	 */
	public LocalDateTime convertToEntityAttribute(final Timestamp timestamp) {
		if (timestamp != null) {
			return new LocalDateTime(timestamp.getTime());
		}
		return null;
	}

}

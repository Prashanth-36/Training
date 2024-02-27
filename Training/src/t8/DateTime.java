package t8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import myException.InvalidValueException;
import utility.Utils;

//day light saving, time zone

public class DateTime {

	public LocalDateTime getDateTime(long millis, ZoneId zone) {
		LocalDateTime dateTime = getZonedDateTime(millis, zone).toLocalDateTime();
		return dateTime;
	}

	public long getCurrentMillis() {
		return Instant.now().toEpochMilli();
	}

	public long getMillis(LocalDateTime date, ZoneId zone) throws InvalidValueException {
		Utils.checkNull(date);
		Instant instant = date.atZone(zone).toInstant();
		return instant.toEpochMilli();
	}

	public long getMillis(LocalDate date, ZoneId zone) throws InvalidValueException {
		Utils.checkNull(date);
		Instant instant = date.atStartOfDay().atZone(zone).toInstant();
		return instant.toEpochMilli();
	}

	public int getYear(long millis, ZoneId zone) {
		ZonedDateTime date = getZonedDateTime(millis, zone);
		return date.getYear();
	}

	public String getMonth(long millis, ZoneId zone) {
		ZonedDateTime date = getZonedDateTime(millis, zone);
		return date.getMonth().toString();
	}

	public String getWeekDay(long millis, ZoneId zone) {
		ZonedDateTime date = getZonedDateTime(millis, zone);
		return date.getDayOfWeek().toString();
	}

	public ZonedDateTime getZonedDateTime(long millis, ZoneId zone) {
		return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), zone);
	}

}

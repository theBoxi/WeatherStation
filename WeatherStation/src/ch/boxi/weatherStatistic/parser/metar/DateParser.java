package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * Parses a METAR date string like 061150Z
 * in: 
 * 06 Day Of Month
 * 11 Hour
 * 50 Minute
 * Z = UTC
 * Year and month is taken from the SystemTime
 * @author boxi
 *
 */
public class DateParser {
	public Date parse(String dateString) throws ParseException{
		Calendar cal = new GregorianCalendar();
		TimeZone utc = new SimpleTimeZone(0, "UTC");
		cal.setTimeZone(utc);
		cal.set(Calendar.DAY_OF_MONTH, 	Integer.parseInt(dateString.substring(0,2)));
		cal.set(Calendar.HOUR_OF_DAY, 	Integer.parseInt(dateString.substring(2,4)));
		cal.set(Calendar.MINUTE, 		Integer.parseInt(dateString.substring(4,6)));
		cal.set(Calendar.SECOND, 		0);
		cal.set(Calendar.MILLISECOND, 	0);
		if(dateString.charAt(6) != 'Z'){
			throw new ParseException("time is not a valid METAR time string", 7);
		}
		return cal.getTime();
	}
}

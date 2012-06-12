package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DateParserTest {
	public static final String METAR_DATE = "061150Z";
	public static final int DAY_OF_MONTH = 6;
	public static final int HOUR_OR_DAY = 13; // because of UTC and western Time & TimeSaving UTC+2
	public static final int MINUTE = 50;
	
	public void testCanParse(){
		DateParser parser = new DateParser();
		Assert.assertEquals("true", parser.canParse(METAR_DATE));
	}
	
	@Test
	public void testDateParser() throws ParseException{
		Calendar cal = parseDate(METAR_DATE);
		Assert.assertEquals(DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(HOUR_OR_DAY, cal.get(Calendar.HOUR_OF_DAY));
		Assert.assertEquals(MINUTE, cal.get(Calendar.MINUTE));
	}
	
	private Calendar parseDate(String metarDate) throws ParseException{
		DateParser parser = new DateParser();
		Date date = parser.parse(metarDate);
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal;
	}
}

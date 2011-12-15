package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import ch.boxi.weatherStatistic.dto.AirPortLocation;
import ch.boxi.weatherStatistic.dto.MeasureType;
import ch.boxi.weatherStatistic.dto.Measurment;

public class MetarParserTest {
	
	@Test
	public void testParser() throws ParseException{
		String metar = "LSZH 141950Z 23012G30KT 9999 FEW040 BKN080 BKN120 06/01 Q1014 TEMPO SHRA";
		MetarParser parser = new MetarParser();
		Measurment measurement = parser.parse(metar);
		Assert.assertEquals("LSZH", ((AirPortLocation)measurement.getLocation()).getIcaoCode());
		Assert.assertEquals(9999, measurement.getMeasurePoints().get(MeasureType.OpticalRange).getAmount(), 0.001);
		Assert.assertEquals(1014, measurement.getMeasurePoints().get(MeasureType.AirPressure).getAmount(), 0.001);
		Assert.assertEquals(230, measurement.getMeasurePoints().get(MeasureType.WindDirection).getAmount(), 0.001);
		Assert.assertEquals(55.56f, measurement.getMeasurePoints().get(MeasureType.Gust).getAmount(), 0.0001);
	}
}

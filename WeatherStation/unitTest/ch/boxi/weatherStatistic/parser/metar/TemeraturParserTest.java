package ch.boxi.weatherStatistic.parser.metar;


import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.boxi.weatherStatistic.dto.MeasurePoint;
import ch.boxi.weatherStatistic.dto.MeasureType;

public class TemeraturParserTest {
	
	private TemperaturParser parser;

	@Before
	public void init(){
		parser = new TemperaturParser();
	}
	
	@Test
	public void testCanPars(){
		Assert.assertTrue(parser.canParse("M1/M2"));
		Assert.assertTrue(parser.canParse("10/1"));
	}
	
	@Test
	public void testParse() throws ParseException{
		assertMeasurePoint(10, 9, parser.parse("10/9"));
		assertMeasurePoint(-10, -1, parser.parse("M10/M1"));
	}
	
	private void assertMeasurePoint(float expTemp, float expDwwpoint, List<MeasurePoint> actualResult){
		Assert.assertEquals(expTemp, getMeasurePoint(MeasureType.Temperatur, actualResult).getAmount(), 0.0001);
		Assert.assertEquals(expDwwpoint, getMeasurePoint(MeasureType.DewPoint, actualResult).getAmount(), 0.0001);
	}
	
	private MeasurePoint getMeasurePoint(MeasureType type, List<MeasurePoint> actualResult){
		for(MeasurePoint point: actualResult){
			if(point.getType() == type){
				return point;
			}
		}
		return null;
	}
}

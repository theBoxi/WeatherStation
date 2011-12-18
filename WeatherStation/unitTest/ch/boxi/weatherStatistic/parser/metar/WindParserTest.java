package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ch.boxi.weatherStatistic.dto.MeasurePoint;
import ch.boxi.weatherStatistic.dto.MeasureType;

public class WindParserTest {

	@Test
	public void testCanParse(){
		WindParser parser = new WindParser();
		Assert.assertTrue(parser.canParse("23008KT"));
		Assert.assertTrue(parser.canParse("23008MPS"));
		Assert.assertTrue(parser.canParse("23008KMH"));
		
		Assert.assertFalse(parser.canParse("1234KT"));
		Assert.assertFalse(parser.canParse("12345"));
		Assert.assertFalse(parser.canParse("12345PS"));
		
		Assert.assertTrue(parser.canParse("23008G25KMH"));
	}
	
	@Test
	public void testParse() throws ParseException{
		WindParser parser = new WindParser();
		assertWind(230, 8, 25, parser.parse("23008G25KMH"));
		assertWind(230, 8, 0, parser.parse("23008KMH"));
		assertWind(230, 200, 0, parser.parse("230200KMH"));
	}
	
	private void assertWind(float direction, float windspeed, float gust, List<MeasurePoint> allPoints){
		Assert.assertEquals(direction, getMeasurePoint(MeasureType.WindDirection, allPoints).getAmount(), 0.0001);
		Assert.assertEquals(windspeed, getMeasurePoint(MeasureType.WindSpeed, allPoints).getAmount(), 0.0001);
		if(gust != 0){
			Assert.assertEquals(gust, getMeasurePoint(MeasureType.Gust, allPoints).getAmount(), 0.0001);
		}
	}
	
	private MeasurePoint getMeasurePoint(MeasureType type, List<MeasurePoint> allPoints){
		for(MeasurePoint point: allPoints){
			if(type == point.getType()){
				return point;
			}
		}
		return null;
	}
}

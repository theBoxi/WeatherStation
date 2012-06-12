package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ch.boxi.weatherStatistic.dto.MeasurePoint;
import ch.boxi.weatherStatistic.dto.MeasureType;

public class WindVariationParserTest {

	@Test
	public void testCanParse(){
		WindDirectionVariationParser parser = new WindDirectionVariationParser();
		Assert.assertTrue(parser.canParse("000V000"));
		Assert.assertTrue(parser.canParse("100V020"));
		Assert.assertTrue(parser.canParse("361V000"));
		
		Assert.assertFalse(parser.canParse("1234"));
		Assert.assertFalse(parser.canParse("123V12"));
		Assert.assertFalse(parser.canParse("12V123"));
	}
	
	@Test
	public void testParse() throws ParseException{
		WindDirectionVariationParser parser = new WindDirectionVariationParser();
		assertWindVariation(0, 0, parser.parse("000V000"));
		assertWindVariation(10, 100, parser.parse("010V100"));
		assertWindVariation(230, 200, parser.parse("230V200"));
	}
	
	private void assertWindVariation(int fromDegree, int toDegree, List<MeasurePoint> allPoints){
		Assert.assertEquals(2, allPoints.size());
		Assert.assertEquals(fromDegree, getMeasurePoint(MeasureType.WindDirectionVariationFrom, allPoints).getAmount(), 0.0001);
		Assert.assertEquals(toDegree, getMeasurePoint(MeasureType.WindDirectionVariationTo, allPoints).getAmount(), 0.0001);
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

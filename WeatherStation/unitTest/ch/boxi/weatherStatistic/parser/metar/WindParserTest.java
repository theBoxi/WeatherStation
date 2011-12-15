package ch.boxi.weatherStatistic.parser.metar;

import org.junit.Assert;
import org.junit.Test;

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
}

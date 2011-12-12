package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.List;

import ch.boxi.weatherStatistic.dto.MeasurePoint;

public class OpticalRangeParser implements MetarSubParser {

	@Override
	public boolean canParse(String phrase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MeasurePoint> parse(String phrase) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

}

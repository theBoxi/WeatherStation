package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.boxi.weatherStatistic.dto.MeasurePoint;
import ch.boxi.weatherStatistic.dto.MeasureType;
import ch.boxi.weatherStatistic.dto.Unit;

public class OpticalRangeParser implements MetarSubParser {

	@Override
	public boolean canParse(String phrase) {
		Pattern pattern = Pattern.compile("\\d{4}");
		Matcher matcher = pattern.matcher(phrase);
		return matcher.matches();
	}

	@Override
	public List<MeasurePoint> parse(String phrase) throws ParseException {
		List<MeasurePoint> retList = new ArrayList<>(1);
		MeasurePoint measure = new MeasurePoint();
		measure.setType(MeasureType.OpticalRange);
		measure.setUnit(Unit.Meter);
		measure.setAmount(Integer.parseInt(phrase));
		return retList;
	}

}

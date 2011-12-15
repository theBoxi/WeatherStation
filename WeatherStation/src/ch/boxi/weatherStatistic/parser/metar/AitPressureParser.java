package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.boxi.weatherStatistic.dto.MeasurePoint;
import ch.boxi.weatherStatistic.dto.MeasureType;
import ch.boxi.weatherStatistic.dto.Unit;

public class AitPressureParser implements MetarSubParser {

	private static final float INCHES_TO_HPA_FACTOR = 33.8677355f;

	@Override
	public boolean canParse(String phrase) {
		Pattern pattern = Pattern.compile("[AQ]\\d{4}");
		Matcher matcher = pattern.matcher(phrase);
		return matcher.matches();
	}

	@Override
	public List<MeasurePoint> parse(String phrase) throws ParseException {
		float amount = Integer.parseInt(phrase.substring(1,5));
		if(phrase.charAt(0) == 'A'){
			amount /= 100;
			amount *= INCHES_TO_HPA_FACTOR;
		}
		List<MeasurePoint> retList = new ArrayList<MeasurePoint>(1);
		retList.add(new MeasurePoint(MeasureType.AirPressure, Unit.HectoPascal, amount));
		return retList;
	}

}

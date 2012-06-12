package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import ch.boxi.weatherStatistic.dto.MeasurePoint;
import ch.boxi.weatherStatistic.dto.MeasureType;
import ch.boxi.weatherStatistic.dto.Unit;

public class WindDirectionVariationParser implements MetarSubParser {

	private static final String EXPRESSION = "(\\d{3})V(\\d{3})";

	@Override
	public boolean canParse(String phrase) {
		Pattern pattern = Pattern.compile(EXPRESSION);
		Matcher matcher = pattern.matcher(phrase);
		return matcher.matches();
	}

	@Override
	public List<MeasurePoint> parse(String phrase) throws ParseException {
		Pattern pattern = Pattern.compile(EXPRESSION);
		Matcher matcher = pattern.matcher(phrase);

		matcher.find();
		int fromDirection = Integer.parseInt(matcher.group(1));
		int toDirection = Integer.parseInt(matcher.group(2));

		List<MeasurePoint> retList = new ArrayList<>(2);
		MeasurePoint measurePointFrom = new MeasurePoint(MeasureType.WindDirectionVariationFrom, Unit.DegreeNorth, fromDirection);
		MeasurePoint measurePointTo   = new MeasurePoint(MeasureType.WindDirectionVariationTo,   Unit.DegreeNorth, toDirection);
		
		retList.add(measurePointFrom);
		retList.add(measurePointTo);
		
		return retList;
	}

}

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

public class TemperaturParser implements MetarSubParser {

	private static final String PATTERN = "(M?)(\\d+)/(M?)(\\d+)";
	private Pattern pattern = Pattern.compile(PATTERN);

	@Override
	public boolean canParse(String phrase) {
		Matcher matcher = pattern.matcher(phrase);
		return matcher.matches();
	}

	@Override
	public List<MeasurePoint> parse(String phrase) throws ParseException {
		Matcher matcher = pattern.matcher(phrase);
		matcher.find();
		
		String minusT = matcher.group(1);
		float temeratur = Integer.parseInt(matcher.group(2));
		String minusD = matcher.group(3);
		float dewPoint = Integer.parseInt(matcher.group(4));
		
		if(StringUtils.isNotEmpty(minusT) && "M".equals(minusT)){
			temeratur *= -1;
		}
		if(StringUtils.isNotEmpty(minusD) && "M".equals(minusD)){
			dewPoint *= -1;
		}
		
		List<MeasurePoint> retList = new ArrayList<>(2);
		retList.add(new MeasurePoint(MeasureType.Temperatur, Unit.DegreeCelsius, temeratur));
		retList.add(new MeasurePoint(MeasureType.DewPoint, Unit.DegreeCelsius, dewPoint));
		return retList;
	}

}

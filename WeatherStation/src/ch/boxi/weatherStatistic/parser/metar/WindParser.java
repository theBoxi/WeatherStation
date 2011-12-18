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

public class WindParser implements MetarSubParser {

	private static final String EXPRESSION = "(\\d{3})(\\d{2,})(G\\d+)?(KT|KMH|MPS)";
	private static final float KT_TO_KMH_FACTOR = 1.852f;
	private static final double MPS_TO_KMH_FACTOR = 3.6;

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
		int direction = Integer.parseInt(matcher.group(1));
		float speed = Integer.parseInt(matcher.group(2));
		String gustString = matcher.group(3);
		float gust = 0;
		if(StringUtils.isNotEmpty(gustString)){
			gust = Integer.parseInt(matcher.group(3).substring(1));

		}
		String unit = matcher.group(4);

		List<MeasurePoint> retList = new ArrayList<>(2);
		MeasurePoint measurePoint = new MeasurePoint(MeasureType.WindDirection, Unit.DegreeNorth, direction);
		retList.add(measurePoint);
		
		if(unit.equals("MPS")){	// m/s
			speed *= MPS_TO_KMH_FACTOR;
			gust *= MPS_TO_KMH_FACTOR;
		} else if(unit.equals("KT")){
			speed *= KT_TO_KMH_FACTOR;
			gust *= KT_TO_KMH_FACTOR;
		}
		measurePoint = new MeasurePoint(MeasureType.WindSpeed, Unit.KilometerPerHour, speed);
		retList.add(measurePoint);
		
		if(gust != 0){
			measurePoint = new MeasurePoint(MeasureType.Gust, Unit.KilometerPerHour, gust);
			retList.add(measurePoint);
		}
		
		return retList;
	}

}

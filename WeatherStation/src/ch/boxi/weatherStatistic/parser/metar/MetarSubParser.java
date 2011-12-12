package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.List;

import ch.boxi.weatherStatistic.dto.MeasurePoint;

public interface MetarSubParser {
	public boolean canParse(String phrase);
	public List<MeasurePoint> parse(String phrase) throws ParseException;
}

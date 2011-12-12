package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;

import ch.boxi.weatherStatistic.dto.MeasurePoint;

public interface MetarSubParser {
	public boolean canParse(String phrase);
	public MeasurePoint parse(String phrase) throws ParseException;
}

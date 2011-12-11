package ch.boxi.weatherStatistic.parser;

import java.text.ParseException;

import ch.boxi.weatherStatistic.dto.Measurment;

public interface MeasureParser {
	public Measurment parse(String data) throws ParseException;
}

package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;

import ch.boxi.weatherStatistic.dto.AirPortLocation;

public class LocationParser{

	public boolean canParse(String phrase) {
		return AirPortLocation.locations.get(phrase) != null;
	}

	public AirPortLocation parse(String phrase) throws ParseException {
		AirPortLocation location = AirPortLocation.locations.get(phrase);
		if(location == null){
			throw new ParseException("ICAO code unknown" , 0);
		}
		return location;
	}
	
}

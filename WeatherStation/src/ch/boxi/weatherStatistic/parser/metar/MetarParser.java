package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import ch.boxi.weatherStatistic.dto.AirPortLocation;
import ch.boxi.weatherStatistic.dto.MeasurePoint;
import ch.boxi.weatherStatistic.dto.Measurment;
import ch.boxi.weatherStatistic.parser.MeasureParser;

public class MetarParser implements MeasureParser{
	private List<MetarSubParser> subParsers = new LinkedList<MetarSubParser>();
	
	public MetarParser(){
	}
	
	@Override
	public Measurment parse(String data) throws ParseException {
		Measurment measurement = new Measurment();
		Set<MeasurePoint> measurePoints = new TreeSet<MeasurePoint>();
		StringTokenizer st = new StringTokenizer(data);
		AirPortLocation location = new LocationParser().parse(st.nextToken());
		Date date = new DateParser().parse(st.nextToken());
		measurement.setLocation(location);
		measurement.setRecordingDate(date);
		while(st.hasMoreTokens()){
			String subData = st.nextToken();
			for(MetarSubParser subParser: subParsers){
				if(subParser.canParse(subData)){
					List<MeasurePoint> parsedData = subParser.parse(subData);
					measurePoints.addAll(parsedData);
				}
			}
		}
		measurement.setMeasurePoints(measurePoints);
		return measurement;
	}

}

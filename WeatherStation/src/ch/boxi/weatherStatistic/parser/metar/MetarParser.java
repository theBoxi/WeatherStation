package ch.boxi.weatherStatistic.parser.metar;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import ch.boxi.weatherStatistic.dto.AirPortLocation;
import ch.boxi.weatherStatistic.dto.MeasurePoint;
import ch.boxi.weatherStatistic.dto.Measurment;
import ch.boxi.weatherStatistic.parser.MeasureParser;

public class MetarParser implements MeasureParser{
	private List<MetarSubParser> subParsers = new LinkedList<MetarSubParser>();
	
	public MetarParser(){
		subParsers.add(new OpticalRangeParser());
		subParsers.add(new AirPressureParser());
		subParsers.add(new WindParser());
		subParsers.add(new TemperaturParser());
		subParsers.add(new WindParser());
		subParsers.add(new WindDirectionVariationParser());
	}
	
	@Override
	public Measurment parse(String data) throws ParseException {
		Measurment measurement = new Measurment();
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
					for(MeasurePoint point: parsedData){
						measurement.getMeasurePoints().put(point.getType(), point);
					}
				}
			}
		}
		return measurement;
	}
}

package ch.boxi.weatherStatistic.dto;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Measurment {
	private Location location;
	private Date recordingDate;
	private Map<MeasureType, MeasurePoint> measurePoints = new TreeMap<MeasureType, MeasurePoint>();
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Date getRecordingDate() {
		return recordingDate;
	}
	public void setRecordingDate(Date recordingDate) {
		this.recordingDate = recordingDate;
	}
	public Map<MeasureType, MeasurePoint> getMeasurePoints() {
		return measurePoints;
	}
	public void setMeasurePoints(Map<MeasureType, MeasurePoint> measurePoints) {
		this.measurePoints = measurePoints;
	}
}

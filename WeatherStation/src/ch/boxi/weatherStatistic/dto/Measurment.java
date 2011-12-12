package ch.boxi.weatherStatistic.dto;

import java.util.Date;
import java.util.Set;


public class Measurment {
	private Location location;
	private Date recordingDate;
	private Set<MeasurePoint> measurePoints;
	
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
	public Set<MeasurePoint> getMeasurePoints() {
		return measurePoints;
	}
	public void setMeasurePoints(Set<MeasurePoint> measurePoints) {
		this.measurePoints = measurePoints;
	}
}

package ch.boxi.weatherStatistic.dto;

public enum Unit {
	  DegreeCelsius("°C")
	, Knot("kt")
	, KilometerPerHour("km/s")
	, MeterPerSecound("m/s")
	, Percent("%")
	, Meter("m")
	, HectoPascal("hPa")
	;
	
	private String abrev;
	
	private Unit(String abrev){
		this.abrev = abrev;
	}
	
	public String getAbrev(){
		return abrev;
	}
}

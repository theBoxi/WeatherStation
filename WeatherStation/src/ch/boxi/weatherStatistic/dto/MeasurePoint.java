package ch.boxi.weatherStatistic.dto;

public class MeasurePoint {
	private MeasureType type;
	private Unit unit;
	private float amount;
	
	public MeasurePoint(){}
	
	public MeasurePoint(MeasureType type, Unit unit, float amount) {
		this();
		this.type = type;
		this.unit = unit;
		this.amount = amount;
	}

	public MeasureType getType() {
		return type;
	}

	public void setType(MeasureType type) {
		this.type = type;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}

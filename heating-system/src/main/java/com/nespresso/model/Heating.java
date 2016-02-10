package com.nespresso.model;

public class Heating {

	private Double temperature;
	private Double threshold;
	private boolean active;

	public Heating(Double temperature, Double threshold, boolean active) {
		this.temperature = temperature;
		this.threshold = threshold;
		this.active = active;
	}

	public boolean verifyIfTemperatureLessThreshold() {
		if (this.temperature < this.threshold && this.active)
			return true;
		return false;
	}

}

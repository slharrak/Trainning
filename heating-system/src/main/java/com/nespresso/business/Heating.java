package com.nespresso.business;

public class Heating {

	private Double temperature;
	private Double threshold;

	public Heating(Double temperature, Double threshold) {
		this.temperature = temperature;
		this.threshold = threshold;
	}

	public boolean verifyIfTemperatureLessThreshold() {
		return (temperature < threshold) ? true : false;
	}

}

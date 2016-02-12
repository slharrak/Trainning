package com.nespresso.heating;

public class Thermostat {

	private Double threshold;

	public Thermostat(final String threshold) {
		this.threshold = Double.parseDouble(threshold);
	}

	public HeatingSystemState toggleState(final Double temperature) {
		if (temperature < threshold) {
			return HeatingSystemState.ON;
		} else if (temperature > threshold) {
			return HeatingSystemState.OFF;
		}
		throw new IllegalStateException();
	}

}

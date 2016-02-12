package com.nespresso.heating;

import com.nespresso.facade.Writer;
import com.nespresso.provider.TemperatureProvider;

public class HeatingSystem {

	private final Thermostat thermostat;
	private final Double temperature;

	public HeatingSystem(final String threshold) {
		this.thermostat = new Thermostat(threshold);
		final String temporalTemperature = new TemperatureProvider().extractFrom("http://probe.home:9990/temp");
		temperature = Double.parseDouble(temporalTemperature);
	}

	public void writeUsing(final Writer writer) {
		final HeatingSystemState state = thermostat.toggleState(temperature);
		state.writeUsing(writer);
	}

}

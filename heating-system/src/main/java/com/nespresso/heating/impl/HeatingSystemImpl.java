package com.nespresso.heating;

import com.nespresso.model.Heating;
import com.nespresso.utils.Writer;

public class HeatingManagerImpl {

	private static final String STATUS_ON = "on";
	private static final String STATUS_OFF = "off";

	public void manageHeating(final Heating heating) {
		if (isTemperatureLessThreshold(heating))
			write(STATUS_ON);
		write(STATUS_OFF);
	}

	private boolean isTemperatureLessThreshold(final Heating heating) {
		return heating.verifyIfTemperatureLessThreshold();
	}

	private void write(final String STATUS) {
		Writer.createSocketAndPrintOnOutputStream(STATUS);
	}
}

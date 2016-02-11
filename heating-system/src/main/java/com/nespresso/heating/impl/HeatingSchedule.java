package com.nespresso.heating.impl;

import java.io.IOException;
import java.net.MalformedURLException;

import com.nespresso.business.HeatingShceduleHour;
import com.nespresso.business.Heating;

public class HeatingSchedule extends HeatingSystemImpl {

	private Double threshold;
	private HeatingShceduleHour heatingShceduleHour;

	private Heating heating;

	public HeatingSchedule(HeatingShceduleHour heatingShceduleHour, Double threshold) {
		this.heatingShceduleHour = heatingShceduleHour;
		this.threshold = threshold;
	}

	@Override
	public void scheduleHealting() throws NumberFormatException, MalformedURLException, IOException {
		if (heatingShceduleHour.checkIfHourOfDayGreatherToStartHour()
				&& heatingShceduleHour.checkIfHourOfDayLessToEndHour()) {
			Double temperature = heatingShceduleHour.getCurrentTemperature(); 
			heating = new Heating(temperature, threshold);
			checkWhitWriteStatus(heating);
		}
	}
}

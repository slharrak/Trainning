package com.nespresso.heating.impl;

import java.io.IOException;
import java.net.MalformedURLException;

import com.nespresso.business.Heating;
import com.nespresso.heating.HeatingSystem;
import com.nespresso.writer.StateWriter;

public abstract class HeatingSystemImpl implements HeatingSystem{

	private static final String STATUS_ON = "on";
	private static final String STATUS_OFF = "off";

	@Override
	public void checkWhitWriteStatus(final Heating heating) throws IOException {
		if (heating.verifyIfTemperatureLessThreshold())
			write(STATUS_ON);
		write(STATUS_OFF);
	}

	private void write(final String STATUS) throws IOException {
		StateWriter.createSocketWithPrintOnOutputStream(STATUS);
	}
	
	public abstract void scheduleHealting() throws MalformedURLException, IOException; 
}

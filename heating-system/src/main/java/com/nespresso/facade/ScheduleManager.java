package com.nespresso.facade;

import java.net.Socket;

import com.nespresso.heating.HeatingSystem;
import com.nespresso.heating.Timer;
import com.nespresso.provider.SocketCreator;
import com.nespresso.provider.TimerProvider;

public class ScheduleManager {

	private TimerProvider timerProvider;

	public ScheduleManager(final TimerProvider timerProvider) {
		this.timerProvider = timerProvider;
	}

	public void manage(final String threshold) throws Exception {
		final int startHour = timerProvider.getStartHour();
		final int endHour = timerProvider.getEndHour();
		final Timer timer = new Timer(startHour, endHour);
		if (timer.canSchedule()) {
			final Socket socket = SocketCreator.getInstance().create("heater.home", 9999);
			new HeatingSystem(threshold).writeUsing(new SocketWriter(socket));
		}
	}

}

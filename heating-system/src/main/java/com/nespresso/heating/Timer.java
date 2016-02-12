package com.nespresso.heating;

import java.util.Calendar;

public class Timer {
	
	private int startHour;
	private int endHour;
	
	public Timer(int startHour, int endHour) {
		this.startHour = startHour;
		this.endHour = endHour;
	}

	public boolean canSchedule() {
		return (actualHour() > startHour && actualHour() < endHour);
	}

	private int actualHour() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}

	
}

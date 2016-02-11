package com.nespresso.business;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;

import com.nespresso.webservice.HealtingShceduleRestImpl;

public class HeatingShceduleHour {
	
	public  static  String HOUR_OF_DAY; 
	private HealtingShceduleRestImpl healtingShceduleRest;
	private Calendar calendar;
	
	public HeatingShceduleHour() {
		calendar = Calendar.getInstance();
	}
	
	public boolean checkIfHourOfDayGreatherToStartHour() throws NumberFormatException, MalformedURLException, IOException{
		return (calendar.get(Calendar.HOUR_OF_DAY) > startHour());
	}
	
	public boolean checkIfHourOfDayLessToEndHour() throws NumberFormatException, MalformedURLException, IOException{
		return (calendar.get(Calendar.HOUR_OF_DAY) < endHour());
	}
	

	private int startHour() throws NumberFormatException, MalformedURLException, IOException {
		healtingShceduleRest = new HealtingShceduleRestImpl("http://timer.home:9990/start", 2);
		return Integer.parseInt(retreiveTemperature());
	}
	
	private int endHour() throws NumberFormatException, MalformedURLException, IOException {
		healtingShceduleRest = new HealtingShceduleRestImpl("http://timer.home:9990/end", 2);
		return Integer.parseInt(retreiveTemperature());
	}
	
	private String retreiveTemperature() throws MalformedURLException, IOException {
		return healtingShceduleRest.readTemperature();
	}
	
	public Double getCurrentTemperature() throws MalformedURLException, IOException {
		healtingShceduleRest = new HealtingShceduleRestImpl("http://probe.home:9990/temp", 4);
		return Double.parseDouble(healtingShceduleRest.readTemperature());
	}
}

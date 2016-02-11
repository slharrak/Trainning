package com.nespresso.webservice;

import com.nespresso.exception.HealtingException;

public interface HealtingShceduleRest {

	String readTemperature() throws HealtingException;
}

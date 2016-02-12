package com.nespresso.provider;

public class TemperatureProvider extends Provider {

	private static final int NUMBER_OF_BYTES = 4;

	@Override
	public String extractFrom(String url) {
		return extract(url, NUMBER_OF_BYTES);
	}

}

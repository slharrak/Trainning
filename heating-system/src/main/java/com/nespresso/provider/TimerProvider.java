package com.nespresso.provider;

public class TimerProvider extends Provider {

	private static final int NUMBER_OF_BYTES = 2;

	@Override
	protected String extractFrom(String url) {
		return extract(url, NUMBER_OF_BYTES);
	}

	public int getStartHour() {
		return Integer.parseInt(extractFrom("http://timer.home:9990/start"));
	}

	public int getEndHour() {
		return Integer.parseInt(extractFrom("http://timer.home:9990/end"));
	}

}

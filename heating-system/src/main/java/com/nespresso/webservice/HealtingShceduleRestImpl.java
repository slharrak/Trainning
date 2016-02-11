package com.nespresso.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HealtingShceduleRestImpl implements HealtingShceduleRest{
	
	public int max;
	private String url;
	
	public HealtingShceduleRestImpl(final String url, final int size) {
		this.max = size;
		this.url = url;
	}

	@Override
	public String readTemperature() throws  IOException {
		final InputStream inputStream = openFromUrl();
		return String.valueOf(readWhitClosing(inputStream));
	}

	private InputStream openFromUrl() throws IOException {
		final URL currentUrl = new URL(url);
		return currentUrl.openStream();
	}

	private byte[] readWhitClosing(final InputStream inputStream) throws IOException {
		byte[] temperatures = new byte[max];
		inputStream.read(temperatures);
		inputStream.close();
		return temperatures;
	}

}

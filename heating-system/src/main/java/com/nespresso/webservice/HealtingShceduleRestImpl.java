package com.nespresso.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class HealtingShceduleRestImpl implements HealtingShceduleRest{
	
	public int size;
	private String url;
	
	public HealtingShceduleRestImpl(String url, int size) {
		this.size = size;
		this.url = url;
	}

	@Override
	public String readTemperature() {
		String temperature = "";
		try {
			URL currentUrl = new URL(url);
			InputStream inputStream = currentUrl.openStream();
			temperature = String.valueOf(readFrom(inputStream));
			close(inputStream);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temperature;
	}

	private byte[] readFrom(final InputStream inputStream) throws IOException {
		byte[] tempBuffer = new byte[size];
		inputStream.read(tempBuffer);
		return tempBuffer;
	}

	private void close(final InputStream inputStream) throws IOException {
		inputStream.close();
	}
}

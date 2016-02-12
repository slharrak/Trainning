package com.nespresso.provider;

import java.io.InputStream;
import java.net.URL;

public abstract class Provider {
	
	protected String extract(final String realUrl, final int numberOfBytes){
		try {
			final URL url = new URL(realUrl);
			final InputStream is = url.openStream();
			final byte[] tempBuffer = new byte[numberOfBytes];
			is.read(tempBuffer);
			final String result = new String(tempBuffer);
			is.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new NumberFormatException();
	}
	
	protected abstract String extractFrom(String url);

}

package com.nespresso.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public final class Writer {

	private final static String HEATER_HOME = "heater.home";
	private final static Integer PORT_NUMBER = 9999;
	
	private static Socket socket; 
	private static OutputStream outputStream; 
	
	public static void createSocketAndPrintOnOutputStream(final String STATUS){
			try {
				createSocket();
				printOnOutputStreamAndCloseSocket(STATUS);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	private static void createSocket() throws UnknownHostException, IOException {
		socket = new Socket(HEATER_HOME, PORT_NUMBER);
	}
	
	private static void printOnOutputStreamAndCloseSocket(final String STATUS) throws IOException {
		outputStream = socket.getOutputStream();
		outputStream.write(STATUS.getBytes());
		outputStream.flush();
		outputStream.close();
		closeSocket();
	}
	
	private static void closeSocket() throws IOException {
		socket.close();
	}
}

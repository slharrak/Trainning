package com.nespresso.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public final class StateWriter {

	private final static String HEATER_HOME = "heater.home";
	private final static Integer PORT_NUMBER = 9999;

	private static Socket socket;
	private static OutputStream outputStream;

	public static void createSocketWithPrintOnOutputStream(final String STATUS) throws IOException {
		createSocket();
		printOnOutputStream(STATUS);
	}

	private static void createSocket() throws UnknownHostException, IOException {
		socket = new Socket(HEATER_HOME, PORT_NUMBER);
	}

	private static void printOnOutputStream(final String STATUS) throws IOException {
		outputStream = socket.getOutputStream();
		outputStream.write(STATUS.getBytes());
		outputStream.flush();
		outputStream.close();
		socket.close();
	}

}

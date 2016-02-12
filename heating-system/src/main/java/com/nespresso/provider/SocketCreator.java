package com.nespresso.provider;

import java.io.IOException;
import java.net.Socket;

public class SocketCreator {

	private static volatile SocketCreator instance = null;
	
	private SocketCreator(){}

	public final static SocketCreator getInstance() {
		if (SocketCreator.instance == null) {
			synchronized (SocketCreator.class) {
				if (SocketCreator.instance == null) {
					SocketCreator.instance = new SocketCreator();
				}
			}
		}
		return SocketCreator.instance;
	}

	public Socket create(final String host, final int port) {
		Socket socket = new Socket();
		try {
			socket = new Socket(host, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return socket;
	}
}

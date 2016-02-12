package com.nespresso.facade;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketWriter implements Writer{

	private Socket socket;
	
	public SocketWriter(final Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void write(final String state) {
		try {
			final OutputStream outputStream = socket.getOutputStream();
			outputStream.write(state.getBytes());
			shutdown(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
		
	}

	private void shutdown(final OutputStream outputStream) throws IOException {
		outputStream.flush();
		outputStream.close();
		socket.close();
	}
}

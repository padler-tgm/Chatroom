package adler_schwarz.communication;

import java.net.*;
import java.io.*;

public class Server extends Thread{
	private ServerSocket serverSocket;
	private MultiCast multi;
	
	public Server(int portNumber){
		this.multi = new MultiCast();
		try {
			this.serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.start();
	}
	
	@Override
	public void run() {
		while(true){
			Socket clientSocket;
			try {
				clientSocket = serverSocket.accept();//listen for connection
				new ThreadServer(clientSocket, multi).start();//startet den Serverthread
			} catch (IOException e) {
				System.out.println("Exception caught when trying to listen on port "+ serverSocket.getLocalPort() + " or listening for a connection");
				System.out.println(e.getMessage());
			}
		}
	}
}
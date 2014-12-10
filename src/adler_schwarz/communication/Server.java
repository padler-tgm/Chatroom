package adler_schwarz.communication;

import java.net.*;
import java.io.*;

/**
 * Diese Klasse stellt den Server dar welcher auf die Clients Listen
 * @author Philipp Adler
 * @author Stefan Schwarz
 *
 * @version 2014-12-10
 */
public class Server extends Thread{
	private ServerSocket serverSocket;//Socket des Server als IP+Port
	private MultiCast multi;//dieses Objekt speichert sich alle Clients um denen die Nachrichten zu schicken
	
	/**
	 * Der Konstruktor erstellt einen Socket für den Server
	 * @param portNumber die Portnummer für den Socket, die IP-Adresse ist die vom Host auf dem der Server läuft
	 */
	public Server(int portNumber){
		this.multi = new MultiCast();
		try {
			this.serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.start();//startet die run Methode wo der Server nur Listen
	}
	
	/**
	 * In der run-Methode wartet der Server auf Client connections
	 */
	@Override
	public void run() {
		while(true){
			Socket clientSocket;
			try {
				clientSocket = serverSocket.accept();//listen for connection
				new ThreadServer(clientSocket, multi).start();//startet den Serverthread wo jeder einzelne Client verwaltet wird
			} catch (IOException e) {
				System.out.println("Exception caught when trying to listen on port "+ serverSocket.getLocalPort() + " or listening for a connection");
				System.out.println(e.getMessage());
			}
		}
	}
}
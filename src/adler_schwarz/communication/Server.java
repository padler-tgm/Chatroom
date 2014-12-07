package adler_schwarz.communication;

import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) throws IOException {
		MultiCast test = new MultiCast();
		int portNumber = Integer.parseInt("4444");//speichert den Port in eine Variable
		try { 
			ServerSocket serverSocket = new ServerSocket(portNumber);//erzeugt ein Serversocket mit einen spezifischen Port
			while(true){
				Socket clientSocket = serverSocket.accept();//listen for connection
				new ThreadServer(clientSocket, test).start();//startet den Serverthread
			}
		} catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port "
					+ portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}
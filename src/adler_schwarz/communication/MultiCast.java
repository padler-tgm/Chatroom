package adler_schwarz.communication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Diese Klasse speichert sich alle Clients die mit dem Server verbunden sind
 * @author Philipp Adler
 * @author Stefan Schwarz
 *
 * @version 2014-12-10
 */
public class MultiCast {
	private ArrayList<Socket> sockets;

	/**
	 * Erzeugt eine leere Liste wo die Sockets von den Clients gespeichert werden
	 */
	public MultiCast(){
		this.sockets = new ArrayList<>();
	}

	/**
	 * Fügt zur Liste den Socket des Client hinzu
	 * @param socket der Socket des Client IP+Port
	 */
	public void addClient(Socket socket){
		this.sockets.add(socket);
	}

	/**
	 * Schreibt die Nachricht an alle Clients
	 * @param eingabe die Nachricht die an alle gehen die mit dem Server verbunden sind
	 */
	public void write(String eingabe){
		try{
			for(Socket socket : this.sockets){
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);//gibt die Client anfragen aus
				out.println(eingabe);//gibt die Antwort des Servers zurück
			}
		}catch(IOException e){
		}
	}
}

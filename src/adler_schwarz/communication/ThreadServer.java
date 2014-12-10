package adler_schwarz.communication;

import java.io.*;
import java.net.Socket;

/**
 * Diese Klasse verwaltet nur einen Client
 * @author Philipp Adler
 * @author Stefan Schwarz
 *
 * @version 2014-12-10
 */
public class ThreadServer extends Thread{
	private Socket socket;//Socket vom Client
	private MultiCast t;
	
	/**
	 * Der Konstruktor speichert sich den Clientsocket in das Attribut
	 * @param s der Socket des Clients
	 */
	public ThreadServer(Socket s, MultiCast t) {
		this.socket = s;
		this.t = t;
		this.t.addClient(s);//fügt dem Client zum MultiCast dazu
	}
	
	/**
	 * Die write Methode übernimmt als Parameter den Text der Nachricht
	 * @param eingabe die Nachricht die an alle Clients geschickt wird
	 */
	public void write(String eingabe){
			this.t.write(eingabe);
	}
	
	/**
	 * Diese Methode liest die empfangenen Nachrichten
	 */
	public void read(){
		try {
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			while ((inputLine = in.readLine()) != null) {//liest die Eingabe vom Client wenn nicht null dann
				this.write(inputLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Hier steht drin was der Thread macht.
	 * In unserem Fall stellt der die Kommunikation zwischen Client und Server dar in dem er auf Nachrichten wartet und 
	 * dann an alle Clients schickt
	 */
	@Override
	public void run() {
		this.read();
	}
}
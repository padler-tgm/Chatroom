package adler_schwarz.communication;

import java.io.*;
import java.net.*;
import java.util.Observable;

/**
 * Diese Klasse stellt den Client dar welcher vom Server die Nachrichten empfängt
 * @author Philipp Adler
 * @author Stefan Schwarz
 *
 * @version 2014-12-10
 */
public class Client extends Observable implements Runnable{
	private Socket socket;//Socket des Clients
	private String eingabe;//speichert die empfange Nachricht vom Server
	
	/**
	 * Der Konstruktor erzeugt einen Socket der auf den Server referenziert
	 * @param host die IP-Adresse des Servers
	 * @param port der Port des Servers
	 * @throws Exception wenn der Server nicht erreichbar ist
	 */
	public Client(String host, int port) throws Exception{
		try {
			this.socket = new Socket(host, port);//erzeugt ein Socket einen Socket mit dem Hostnamen und den Port des Servers
		} catch (UnknownHostException e) {
			throw new Exception("Server nicht erreichbar");
		} catch (IOException e) {
			throw new Exception("Server nicht erreichbar");
		}
	}
	
	/**
	 * Schreibt an den Server die übergebene Nachricht
	 * @param eingabe die Nachricht die an den Server geschickt wird
	 */
	public void write(String eingabe){
		try {
			PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
			out.println(eingabe);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Liest vom Server die Nachrichten
	 */
	public void read(){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			String fromServer;
			while ((fromServer = in.readLine()) != null) {//liest die Antwort vom Server und schaut ob nicht null
				this.eingabe = fromServer;
				setChanged();
				notifyObservers();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Diese Methode gibt die empfangene Nachricht zurück
	 * @return empfangene Nachricht vom Server
	 */
	public String getText(){
		return this.eingabe;
	}
	
	/**
	 * Wartet auf Nachrichten vom Server
	 */
	@Override
	public void run() {
		this.read();
	}
}
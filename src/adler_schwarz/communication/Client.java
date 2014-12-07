package adler_schwarz.communication;
import java.io.*;
import java.net.*;
import java.util.Observable;

import adler_schwarz.grafik.GUIChatroom;

public class Client extends Observable{
	private Socket socket;
	private String eingabe;
	public Client(String host, int port) throws Exception{
		try {
			this.socket = new Socket(host, port);//erzeugt ein Socket einen Socket mit dem Hostnamen und den Port des Servers
		} catch (UnknownHostException e) {
			throw new Exception("Server nicht erreichbar");
		} catch (IOException e) {
			throw new Exception("Server nicht erreichbar");
		}
	}
	public void write(String eingabe){
		try {
			PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
			out.println(eingabe);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
	
	public String getText(){
		return this.eingabe;
	}
}
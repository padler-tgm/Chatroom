package adler_schwarz.communication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ThreadServer extends Thread{
	private Socket socket;
	private MultiCast t;
	
	/**
	 * Der Konstruktor speichert sich den Clientsocket in das Attribut
	 * @param s der Socket des Clients
	 */
	public ThreadServer(Socket s, MultiCast t) {
		this.socket = s;
		this.t = t;
		this.t.addClient(s);
	}
	
	public void write(String eingabe){
			this.t.write(eingabe);
	}
	
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
	 * In unserem Fall stellt der die Kommunikation zwischen Client und Server dar
	 */
	@Override
	public void run() {
		this.read();
	}
}
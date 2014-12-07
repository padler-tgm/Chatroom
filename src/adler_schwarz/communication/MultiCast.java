package adler_schwarz.communication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MultiCast {
	private ArrayList<Socket> sockets;

	public MultiCast(){
		this.sockets = new ArrayList<>();
	}

	public void addClient(Socket socket){
		this.sockets.add(socket);
	}

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

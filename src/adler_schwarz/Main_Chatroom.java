package adler_schwarz;

import adler_schwarz.communication.Client;
import adler_schwarz.grafik.Controller;

public class Main_Chatroom {
	public static void main(String[] args){
		try {
			new Controller(new Client("localhost", 4444));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}

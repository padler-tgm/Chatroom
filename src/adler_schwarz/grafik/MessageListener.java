package adler_schwarz.grafik;

import adler_schwarz.communication.Client;

public class MessageListener extends Thread{
	private Client cl;
	public MessageListener(Client cl){
		this.cl = cl;
		this.start();
	}
	
	@Override
	public void run() {
		this.cl.read();
	}
}

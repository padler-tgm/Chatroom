package adler_schwarz;

import adler_schwarz.grafik.Controller;

/**
 * Diese Klasse ist die Main Klasse welche den Controller startet der sich um den Rest kümmert
 * @author Philipp Adler
 * @author Stefan Schwarz
 *
 * @version 2014-12-10
 */
public class Main_Chatroom {
	
	/**
	 * Die Main-Methode welche den Controller startet 
	 * @param args Argument die auf der Konsole eingebenen werden können
	 */
	public static void main(String[] args){
		new Controller();
	}
}

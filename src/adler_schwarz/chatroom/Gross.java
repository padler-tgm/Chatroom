package adler_schwarz.chatroom;

/**
 * Decorator-Klasse um alle Buchstaben in Gro�buchstaben umzuwandeln
 * @author Philipp Adler
 * @author Stefan Schwarz
 * 
 * @version 2014-12-09
 */
public class Gross extends Decorator{
	
	/**
	 * speichert das Object, welches von dieser Klasse erweitert wird
	 * @param t, die Decorator Klasse, welche durch diese erweitert wird
	 */
	public Gross(Text t) {
		this.t = t;
	}
	
	/**
	 * gibt den gespeicherten Text in Gro�buchstaben zur�ck
	 * @return der Text in Gro�buchstaben
	 */
	@Override
	public String schreiben() {		
		return t.schreiben().toUpperCase();		
	}	
}
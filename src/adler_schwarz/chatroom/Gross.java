package adler_schwarz.chatroom;

/**
 * Decorator-Klasse um alle Buchstaben in Großbuchstaben umzuwandeln
 * 
 * @author Adler
 * @author Schwarz
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
	 * gibt den gespeicherten Text in Großbuchstaben zurück
	 * @return der Text in Großbuchstaben
	 */
	@Override
	public String schreiben() {		
		return t.schreiben().toUpperCase();		
	}	
}
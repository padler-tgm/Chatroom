package adler_schwarz.chatroom;

/**
 * Decorator-Klasse die einzelne Buchstaben des Textes verdoppelt
 * 
 * @author Adler
 * @author Schwarz
 * @version 2014-12-09
 */
public class Doppel extends Decorator{
	
	/**
	 * speichert das Object, welches von dieser Klasse erweitert wird
	 * @param t, die Decorator Klasse, welche durch diese erweitert wird
	 */
	public Doppel(Text t) {
		this.t = t;
	}

	/**
	 * gibt den gespeicherten Text  mit doppelten Buchstaben zurück
	 * @return der Text mit doppelten Buchstaben
	 */
	@Override
	public String schreiben() {
		String text = t.schreiben();
		String temp = "";
		for(int i=0;i<text.length();i++){
			temp += text.substring(i, i+1) + text.substring(i, i+1);
		}
		return temp;
	}
}
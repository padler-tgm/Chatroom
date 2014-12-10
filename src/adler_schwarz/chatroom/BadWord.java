package adler_schwarz.chatroom;
import adler_schwarz.file.File;

/**
 * Decorator-Klasse die den Text auf badWords filtert und diese durch "$%&*" ersetzt
 * 
 * @author Adler
 * @author Schwarz
 * @version 2014-12-09
 */
public class BadWord extends Decorator {

	/**
	 * speichert das Object, welches von dieser Klasse erweitert wird
	 * @param t, die Decorator Klasse, welche durch diese erweitert wird
	 */
	public BadWord(Text t) {
		this.t = t;
	}
	
	/**
	 * öffnet einen FileInputStream und ruft die Methode isBadWord auf, 
	 * welche bei einem badWord true zurückgibt
	 * dieses badWord wird dann durch "$%&*" ersetzt
	 * 
	 * @return der Text ohne böse wörter
	 */
	@Override
	public String schreiben() {
		String ausgabe = t.schreiben();
		File badwords = new File(false);
		if(badwords.isBadWord(t.schreiben().toLowerCase()))ausgabe = "$%&*";
		badwords.close();
		return ausgabe;
	}

}

package adler_schwarz.chatroom;
import adler_schwarz.file.File;

/**
 * Decorator-Klasse die den Text auf badWords filtert und diese durch "$%&*" ersetzt
 * @author Philipp Adler
 * @author Stefan Schwarz
 * 
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
	 * �ffnet einen FileInputStream und ruft die Methode isBadWord auf, 
	 * welche bei einem badWord true zur�ckgibt
	 * dieses badWord wird dann durch "$%&*" ersetzt
	 * 
	 * @return der Text ohne b�se w�rter
	 */
	@Override
	public String schreiben() {
		String ausgabe = "";//splitten auf properties words aufpassen like raFi
		String[] text = t.schreiben().split(" ");
		File badwords = new File(false);
		for(int i=0; i<text.length; i++){
			if(badwords.isBadWord(text[i].toLowerCase())){
				ausgabe += "$%&*";
			}else{
				ausgabe += text[i];
			}
			if(i != text.length-1)ausgabe += " ";
		}
		badwords.close();
		return ausgabe;
	}

}

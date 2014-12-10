package adler_schwarz.chatroom;

/**
 * Decorator-Klasse die Wörter wie "lachen, *lachen*,..." durch das Wort "lol" ersetzt
 * 
 * @author Adler
 * @author Schwarz
 * @version 2014-12-09
 */
public class Lol extends Decorator{
	private String[] words = {"lachen", "*lachen*", "lach", "*lach*"};//liste der zu ersetzenden Wörter
	
	/**
	 * speichert das Object, welches von dieser Klasse erweitert wird
	 * @param t, die Decorator Klasse, welche durch diese erweitert wird
	 */
	public Lol(Text t) {
		this.t = t;
	}
	
	/**
	 * sucht Wörter wie "lachen, ..." und ersetzt sie durch ein simples "lol"
	 * @return der Text mit den Wörtern durch "lol" ersetzt
	 */
	@Override
	public String schreiben() {
		String text = t.schreiben().toLowerCase();
		for(int i=0;i<words.length;i++){
			text= text.replace(this.words[i], "lol");
		}
		return text;
	}	
}
package adler_schwarz.chatroom;

/**
 * Decorator-Klasse die W�rter wie "lachen, *lachen*,..." durch das Wort "lol" ersetzt
 * @author Philipp Adler
 * @author Stefan Schwarz
 * 
 * @version 2014-12-09
 */
public class Lol extends Decorator{
	private String[] words = {"lachen", "*lachen*", "lach", "*lach*"};//liste der zu ersetzenden W�rter
	
	/**
	 * speichert das Object, welches von dieser Klasse erweitert wird
	 * @param t, die Decorator Klasse, welche durch diese erweitert wird
	 */
	public Lol(Text t) {
		this.t = t;
	}
	
	/**
	 * sucht W�rter wie "lachen, ..." und ersetzt sie durch ein simples "lol"
	 * @return der Text mit den W�rtern durch "lol" ersetzt
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
package adler_schwarz.chatroom;

/**
 * Core-Klasse, enth�lt den unformatierten Text
 * @author Philipp Adler
 * @author Stefan Schwarz
 * 
 * @version 2014-12-09
 */
public class Chatroom implements Text{
	private String textinhalt;
	
	/**
	 * leert den text
	 */
	public Chatroom(){
		this.textinhalt ="";
	}
	
	/**
	 * setzt den Text
	 * @param der text der gesetzt werden soll
	 */
	public void setText(String text){
		this.textinhalt = text;
	}
	
	/**
	 * Gibt den Text zur�ck
	 * @return der Text
	 */
	@Override
	public String schreiben() {
		return this.textinhalt;
	}
}

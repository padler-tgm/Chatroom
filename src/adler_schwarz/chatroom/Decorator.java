package adler_schwarz.chatroom;

/**
 * Oberklasse für alle Decorator-Klassen
 * 
 * @author Adler
 * @author Schwarz
 * @version 2014-12-09
 */
public abstract class Decorator implements Text{
	protected Text t;
	
	/**
	 * Speichert den text in t
	 * @param der zu speichernde text
	 */
	@Override
	public void setText(String text) {
		t.setText(text);
	}
}
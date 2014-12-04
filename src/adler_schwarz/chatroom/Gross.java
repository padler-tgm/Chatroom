package adler_schwarz.chatroom;

public class Gross extends Decorator{
	public Gross(Text t) {
		this.t = t;
	}
	
	@Override
	public String schreiben() {		
		return t.schreiben().toUpperCase();		
	}	
}
package adler_schwarz_chatroom;

public class Chatroom implements Text{
	private String textinhalt;
	public Chatroom(String text){
		this.textinhalt = text;
	}
	
	@Override
	public String schreiben() {
		return this.textinhalt;
	}
}

package adler_schwarz.chatroom;

public class Chatroom implements Text{
	private String textinhalt;
	public Chatroom(){
		this.textinhalt ="";
	}
	
	public void setText(String text){
		this.textinhalt = text;
	}
	
	@Override
	public String schreiben() {
		return this.textinhalt;
	}
}

package adler_schwarz_chatroom;

public class Lol extends Decorator{
	private String[] words = {"lachen", "*lachen*", "lach", "*lach*"};
	private String text;
	
	public Lol(Text t) {
		this.t = t;
		text = t.schreiben();
	}
	
	public String schreiben() {		
		for(int i=0;i<words.length;i++){
			text = text.replace(this.words[i], "lol");
		}
		return text;
	}	
}
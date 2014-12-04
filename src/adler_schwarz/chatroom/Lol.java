package adler_schwarz.chatroom;

public class Lol extends Decorator{
	private String[] words = {"lachen", "*lachen*", "lach", "*lach*"};
	public Lol(Text t) {
		this.t = t;
	}
	
	@Override
	public String schreiben() {
		String text = t.schreiben().toLowerCase();
		for(int i=0;i<words.length;i++){
			text= text.replace(this.words[i], "lol");
		}
		return text;
	}	
}
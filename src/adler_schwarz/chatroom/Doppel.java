package adler_schwarz.chatroom;

public class Doppel extends Decorator{
	public Doppel(Text t) {
		this.t = t;
	}

	@Override
	public String schreiben() {
		String text = t.schreiben();
		String temp = "";
		for(int i=0;i<text.length();i++){
			temp += text.substring(i, i+1) + text.substring(i, i+1);
		}
		return temp;
	}
}
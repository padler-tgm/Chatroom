package adler_schwarz.chatroom;

import adler_schwarz.file.File;

public class BadWord extends Decorator {

	public BadWord(Text t) {
		this.t = t;
	}
	
	@Override
	public String schreiben() {
		String ausgabe = t.schreiben();
		File badwords = new File(false);
		if(badwords.isBadWord(t.schreiben().toLowerCase()))ausgabe = "$%&*";
		badwords.close();
		return ausgabe;
	}

}

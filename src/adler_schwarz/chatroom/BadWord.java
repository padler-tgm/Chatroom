package adler_schwarz.chatroom;

import adler_schwarz.file.File;

public class BadWord extends Decorator {

	public BadWord(Text t) {
		this.t = t;
	}

	@Override
	public String schreiben() {
		String ausgabe = "";//splitten auf properties words aufpassen like raFi
		String[] text = t.schreiben().split(" ");
		File badwords = new File(false);
		for(int i=0; i<text.length; i++){
			if(badwords.isBadWord(text[i].toLowerCase())){
				ausgabe += "$%&*";
			}else{
				ausgabe += text[i];
			}
			if(i != text.length-1)ausgabe += " ";
		}
		badwords.close();
		return ausgabe;
	}
}

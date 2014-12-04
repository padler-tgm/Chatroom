package adler_schwarz.chatroom;

public abstract class Decorator implements Text{
	Text t;
	@Override
	public void setText(String text) {
		t.setText(text);
	}
}
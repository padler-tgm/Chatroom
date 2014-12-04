package adler_schwarz.chatroom;

public abstract class Decorator implements Text{
	protected Text t;
	@Override
	public void setText(String text) {
		t.setText(text);
	}
}
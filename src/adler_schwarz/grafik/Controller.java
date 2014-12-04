package adler_schwarz_grafik;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import adler_schwarz_chatroom.Chatroom;
import adler_schwarz_chatroom.Doppel;
import adler_schwarz_chatroom.Gross;
import adler_schwarz_chatroom.Lol;
import adler_schwarz_chatroom.Text;

public class Controller implements ActionListener{
	private Text ct;
	private GUI g;
	
	public Controller(){
		this.g = new GUI(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o instanceof JButton){
			JButton button = (JButton) o;
		}
		this.ct = new Chatroom(this.g.getEingabe());
		this.ct = new Lol(this.ct);
		this.ct = new Doppel(this.ct);
		this.ct = new Gross(this.ct);
		this.g.setTextArea(this.ct.schreiben());
		
	}
}

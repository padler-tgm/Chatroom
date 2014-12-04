package adler_schwarz.grafik;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import adler_schwarz.chatroom.Chatroom;
import adler_schwarz.chatroom.Doppel;
import adler_schwarz.chatroom.Gross;
import adler_schwarz.chatroom.Lol;
import adler_schwarz.chatroom.Text;

public class Controller implements ActionListener{
	private Text ct;
	private GUI g;
	
	public Controller(){
		this.ct = new Chatroom();
		this.ct = new Lol(this.ct);
		this.ct = new Doppel(this.ct);
		this.ct = new Gross(this.ct);
		this.g = new GUI(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o instanceof JButton){
			this.ct.setText(this.g.getEingabe());
			this.g.setTextArea(this.ct.schreiben());
		}
	}
}

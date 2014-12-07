package adler_schwarz.grafik;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import adler_schwarz.chatroom.*;
import adler_schwarz.communication.Client;
import adler_schwarz.file.File;

public class Controller implements ActionListener, Observer{
	private Observable observable;
	private Text ct;
	private GUIChatroom g;
	private GUIVerwaltung v;

	public Controller(Observable observable){
		this.ct = new Chatroom();
		this.ct = new Lol(this.ct);
		this.ct = new BadWord(this.ct);
		this.ct = new Doppel(this.ct);
		this.ct = new Gross(this.ct);
		this.g = new GUIChatroom(this);
		this.observable = observable;
		this.observable.addObserver(this);
		new MessageListener((Client)this.observable);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o instanceof JButton){
			JButton button = (JButton)o;
			if(button.getActionCommand().equals("s")){
				((Client)this.observable).write(this.g.getEingabe());
			}else if(button.getActionCommand().equals("b")){
				this.v = new GUIVerwaltung(this);
				File file = new File(false);
				this.v.setTextArea(file.getData());
				file.close();
			}else if(button.getActionCommand().equals("speichern")){
				File file = new File(true);
				String[] eingaben = this.v.getTextArea().split("\n");
				System.out.println(eingaben.length);
				for(String text : eingaben){
					file.setData(text);
				}
				file.close();
			}else if(button.getActionCommand().equals("back")){
				this.v.dispose();
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Client){
			Client client = (Client)o;
			System.out.println(client.getText());
			this.ct.setText(client.getText());
			this.g.setTextArea(this.ct.schreiben());
		}
		
	}
}

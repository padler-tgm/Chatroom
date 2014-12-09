package adler_schwarz.grafik;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import adler_schwarz.chatroom.*;
import adler_schwarz.communication.Client;
import adler_schwarz.communication.Server;
import adler_schwarz.file.File;

public class Controller implements ActionListener, Observer{
	private Observable observable;
	private Text ct;
	private GUIChatroom g;
	private GUIVerwaltung v;
	private GUIStart st;

	public Controller(){
		this.st = new GUIStart(this);
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
			}else if(button.getActionCommand().equals("anmelden")){
				if(this.st.isChecked())new Server(Integer.parseInt(this.st.getPort()));
				this.st.dispose();

				try {
					this.observable = new Client(this.st.getIP(),Integer.parseInt(this.st.getPort()));
					this.observable.addObserver(this);
				} catch (Exception e1) {
					e1.printStackTrace();
					System.exit(0);
				}
				this.ct = new Chatroom();
				this.ct = new Gross(new Doppel(new BadWord(new Lol(this.ct))));
				this.g = new GUIChatroom(this);
				new Thread(((Client)this.observable)).start();
			}
		}
		if(o instanceof JCheckBox){
			if(this.g.isChecked()){
				this.ct = new Chatroom();
				this.ct = new Gross(new Doppel(new Lol(this.ct)));
			}else{
				this.ct = new Chatroom();
				this.ct = new Gross(new Doppel(new BadWord(new Lol(this.ct))));
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

package adler_schwarz.grafik;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import adler_schwarz.chatroom.*;
import adler_schwarz.communication.*;
import adler_schwarz.file.File;

/**
 * Diese Klasse verwaltet den ganzen Chatroom, agiert mit der GUI und den Client der mit dem Server kommuniziert
 * @author Philipp Adler
 * @author Stefan Schwarz
 *
 * @version 2014-12-10
 */
public class Controller implements ActionListener, Observer{
	private Observable observable;//bekommt vom Observer neue Informationen, also die Nachrichten von den anderen Clients
	private Text ct;//Model welches sich im Decorator-Pattern befindet, dynamisch zur Laufzeit änderbar
	private GUIChatroom g;//GUI für den Chatroom
	private GUIVerwaltung v;//GUI für die Badwords Verwaltung
	private GUIStart st;//GUI für das Startfenster wo man die Adresse des Servers angibt

	/**
	 * Der Controller startet das Startfenster wo man die IP vom Server angibt
	 */
	public Controller(){
		this.st = new GUIStart(this);
	}
	
	/**
	 * Wenn ein Button oder eine Checkbox von der GUI gedrückt wird, werden hier die Datenverwaletet bzw. gesteuert
	 * @param e beinhaltet Informationen über das gedrückte Element
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o instanceof JButton){//wenn ein Button gedrückt wurde
			JButton button = (JButton)o;//wandelt das Objekt in einen Button
			
			if(button.getActionCommand().equals("anmelden")){//wenn der Client sich mit dem Server connecten möchte
				//wenn die Checkbox selected ist wird der Server auf dem Host gestartet
				if(this.st.isChecked())new Server(Integer.parseInt(this.st.getPort()));
				this.st.dispose();

				try {
					this.observable = new Client(this.st.getIP(),Integer.parseInt(this.st.getPort()));//erzeugt einen Client
					this.observable.addObserver(this);//möchte vom Observable Daten bekommen wenn es welche gibt
				} catch (Exception e1) {//falls es die IP-Adresse vom Server nicht gibt wird das Programm beendet
					e1.printStackTrace();
					System.exit(0);
				}
				this.ct = new Chatroom();//starten den Core im Decorator-Pattern
				this.ct = new Gross(new Doppel(new BadWord(new Lol(this.ct))));//dekoriert das Objekt
				this.g = new GUIChatroom(this);//startet die GUI für den Chatroom
				new Thread(((Client)this.observable)).start();//startet den Client welcher in einer Schleife auf Nachrichten wartet
			}
			
			else if(button.getActionCommand().equals("s")){//wenn der Client eine Nachricht an den Server schicken möchte
				((Client)this.observable).write(this.g.getEingabe());
			}
			
			else if(button.getActionCommand().equals("b")){//wenn der Client die Badwords verwalten möchte
				this.v = new GUIVerwaltung(this);
				File file = new File(false);//liest das Properties-File
				this.v.setTextArea(file.getData());
				file.close();//schließt das Properties-File
			}
			
			else if(button.getActionCommand().equals("speichern")){//wenn die Badwords in das Properties-File gespeichert werden sollen
				File file = new File(true);//schreibt in das Properties-File
				file.write(this.v.getTextArea().split("\n"));
				file.close();
			}
			
			else if(button.getActionCommand().equals("back")){//wenn der Benutzer vom Badword verwalten zurück zum Chatroom Fenster möchte
				this.v.dispose();
			}
		}
		
		if(o instanceof JCheckBox){//wenn sich beim gedrückten Objekt um keinen Button sondern um eine Checkbox handelt
			if(this.g.isChecked()){//wenn der Benutzer die Badwords deaktivieren möchte
				this.ct = new Chatroom();
				this.ct = new Gross(new Doppel(new Lol(this.ct)));
			}else{//wenn der Benutzer die Badwords aktivieren möchte
				this.ct = new Chatroom();
				this.ct = new Gross(new Doppel(new BadWord(new Lol(this.ct))));
			}
		}
	}

	/**
	 * Da wir ein Observer sind warten wir darauf neue Daten bzw. Nachrichten zu bekommen
	 * @args o vom Typ Observable wo wir uns die Daten holen können
	 * @args arg ein Argument was von der notify Methode weitergegeben wurde
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Client){
			Client client = (Client)o;
			this.ct.setText(client.getText());//holt sich die Daten vom Observable
			this.g.setTextArea(this.ct.schreiben());//gibt auf der GUI aus
		}
	}
}
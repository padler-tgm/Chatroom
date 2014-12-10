package adler_schwarz.grafik;

import java.awt.*;
import javax.swing.*;

/**
 * Diese Klasse stellt die GUI für den Chatroom dar. Sie beinhaltet 2 Textareas und 3 Button mit verschiedenen Funktionen
 * @author Philipp Adler
 * @author Stefan Schwarz
 *
 * @version 2014-12-10
 */
public class GUIChatroom extends JFrame{
	private Controller c;//als Listener für die Buttons und für die Checkbox
	private TextArea send,rec;//eine Textarea für das empfangen und senden von Nachrichten
	private JCheckBox check;//ob die Badword Funktion deaktiviert oder aktiviert werden soll
	
	/**
	 * Der Konstruktor hat als Parameter den Listener für die Buttons und für die Checkbox
	 * @param c der Controller als Listener für die GUI Elemente
	 */
	public GUIChatroom(Controller c){
		this.c = c;
		this.init();//erzeugt die GUI für den Chatroom
	}

	/**
	 * Erzeugt die GUI für den Chatroom includiert 2 Textareas, 2 Buttons und einer Checkbox 
	 */
	public void init(){
		this.send = new TextArea();
		this.rec=new TextArea();
		this.rec.setEditable(false);
		
		JPanel panel2 = new JPanel(new GridLayout(3,1));
		this.check = new JCheckBox("Badwords deaktivieren");
		this.check.setActionCommand("badword");
		this.check.addActionListener(this.c);
		panel2.add(this.check);
		JButton b1 = new JButton("Senden");
		b1.setActionCommand("s");
		b1.addActionListener(c);
		panel2.add(b1);
		JButton b2 = new JButton("Badwords bearbeiten");
		b2.setActionCommand("b");
		b2.addActionListener(c);
		panel2.add(b2);
		
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(panel2,BorderLayout.EAST);
		panel1.add(send);
		
		JPanel panel = new JPanel(new GridLayout(2,1));
		panel.add(rec);
		panel.add(panel1);
		add(panel);
		setVisible(true);
		setSize(600,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Diese Methode gibt den Inhalt der Benutzereingabe zurück
	 * @return die Eingabe des Benutzers
	 */
	public String getEingabe(){
		return this.send.getText();
	}

	/**
	 * Diese Methode gibt die übergebene Nachricht in der Textarea aus
	 * @param text die neue Nachricht vom Chatroom
	 */
	public void setTextArea(String text){
		this.rec.setText(this.rec.getText()+"\n"+text);
		this.send.setText("");
		this.rec.setSelectionStart(this.rec.getText().length());
	}
	
	/**
	 * Überprüft ob die Checkbox für die Badwords aktiviert/deaktiviert ist
	 * @return gibt zurück ob die Checkbox selected ist
	 */
	public boolean isChecked(){
		if(this.check.isSelected()){
			this.check.setText("Badwords aktivieren");
		}else{
			this.check.setText("Badwords deaktivieren");
		}
		return this.check.isSelected();
	}
}
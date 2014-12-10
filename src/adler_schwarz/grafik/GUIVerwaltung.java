package adler_schwarz.grafik;

import java.awt.*;

import javax.swing.*;

/**
 * Diese Klasse erstellt die GUI für das Verwalten der Badwords
 * @author Philipp Adler
 * @author Stefan Schwarz
 *
 * @version 2014-12-10
 */
public class GUIVerwaltung extends JFrame{
	private Controller c;
	private TextArea badwords;
	
	/**
	 * Der Konstruktor erzeugt die GUI
	 * @param c der Listener für die Button
	 */
	public GUIVerwaltung(Controller c){
		this.c = c;
		this.init();
	}
	
	/**
	 * erzeugt die GUI für das Verwalten der Badwords 
	 */
	public void init(){
		JPanel panel = new JPanel(new BorderLayout());
		JPanel panel1 = new JPanel(new GridLayout(1, 2));
		JButton speichern = new JButton("speichern");
		speichern.setActionCommand("speichern");
		speichern.addActionListener(this.c);
		JButton back = new JButton("zurück");
		back.setActionCommand("back");
		back.addActionListener(this.c);
		panel1.add(speichern);
		panel1.add(back);
		
		this.badwords = new TextArea();
		panel.add(badwords);
		panel.add(panel1,BorderLayout.SOUTH);
		add(panel);
		setVisible(true);
		setSize(600,300);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Diese Methode übernimmt den übergebenen Parameter als Inhalt der Textarea
	 * @param text der neue Text der Textarea
	 */
	public void setTextArea(String text){
		this.badwords.setText(text);
	}
	
	/**
	 * Diese Methode gibt den Inhalt der Textarea zurück
	 * @return den Inhalt welche die Badwords darstellen
	 */
	public String getTextArea(){
		return this.badwords.getText();
	}
}
package adler_schwarz.grafik;

import java.awt.*;
import javax.swing.*;

/**
 * Diese Klasse erstellt die GUI zum Anmelden zu einen Chatroom
 * @author Philipp Adler
 * @author Stefan Schwarz
 *
 * @version 2014-12-10
 */
public class GUIStart extends JFrame{
	private JTextField ip;//Textfeld für die Eingabe der IP-Adresse
	private JTextField port;//Textfeld für die Eingabe den Port
	private JCheckBox check;//Checkbox ob der Server auf dem Host gestartet werden soll
	private Controller c;//Listener für den Button
	
	/**
	 * Der Konstruktor erzeugt die GUI
	 * @param c der Listener für die Button
	 */
	public GUIStart(Controller c){
		this.c = c;
		this.init();
	}
	
	/**
	 * erzeugt die GUI für das Anmelden am Chatroom
	 */
	public void init(){
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
		this.ip = new JTextField();
		JLabel beschrieftung = new JLabel("IP:");
		panel.add(beschrieftung);
		panel.add(this.ip);
		this.port = new JTextField();
		JLabel beschrieftung1 = new JLabel("Port:");
		panel.add(beschrieftung1);
		panel.add(this.port);
		this.check = new JCheckBox("Server starten");
		panel.add(check);
		panel1.add(panel);
		JButton button = new JButton("anmelden");
		button.setActionCommand("anmelden");
		button.addActionListener(this.c);
		panel1.add(button,BorderLayout.SOUTH);
		this.add(panel1);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(500, 150);
		setResizable(false);
	}
	
	/**
	 * Die Methode gibt die eingegebene IP-Adresse aus
	 * @return die vom Benutzer eingegebene IP-Adresse zurück
	 */
	public String getIP(){
		return this.ip.getText();
	}
	
	/**
	 * Die Methode gibt den eingegebenen Port aus
	 * @return die vom Benutzer eingegebenen Port zurück
	 */
	public String getPort(){
		return this.port.getText();
	}
	
	/**
	 * Gibt aus ob die Checkbox selected ist
	 * @return ob selected true
	 */
	public boolean isChecked(){
		return this.check.isSelected();
	}
}
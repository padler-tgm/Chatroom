package adler_schwarz.grafik;

import java.awt.*;
import javax.swing.*;

/**
 * Diese Klasse erstellt die GUI zum Anmelden zu einen Chatroom
 * @author Philipp Adler
 * @author Adin Karic
 *
 * @version 2014-11-20
 */
public class GUIStart extends JFrame{
	private JTextField ip;
	private JTextField port;
	private JCheckBox check;
	private Controller c;//Listener für den Button
	
	/**
	 * Der Konstruktor erzeugt die GUI
	 * @param c der Listener für die Button
	 */
	public GUIStart(Controller c){
		this.c = c;
		this.init();
	}
	
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
	 * Diese Methode gibt den Inhalt der Eingaben als String Array zurück
	 * @return die Inhalte der Textfelder
	 */
	public String getIP(){
		return this.ip.getText();
	}
	
	public String getPort(){
		return this.port.getText();
	}
	
	public boolean isChecked(){
		return this.check.isSelected();
	}
}

package adler_schwarz.grafik;

import java.awt.*;

import javax.swing.*;

public class GUIVerwaltung extends JFrame{
	private Controller c;
	private TextArea badwords;
	public GUIVerwaltung(Controller c){
		this.c = c;
		this.init();
	}
	
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
	
	public void setTextArea(String text){
		this.badwords.setText(text);
	}
	
	public String getTextArea(){
		return this.badwords.getText();
	}
}

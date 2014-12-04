package adler_schwarz.grafik;

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
	private Controller c;
	private TextArea send,rec;
	public GUI(Controller c){
		this.c = c;
		this.init();
	}

	public void init(){
		this.send = new TextArea();
		this.rec=new TextArea();
		this.rec.setEditable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		
		JButton b = new JButton("Senden");
		b.addActionListener(c);
		panel1.add(b,BorderLayout.EAST);
		panel1.add(send);
		
		panel.add(rec);
		panel.add(panel1);
		add(panel);
		setVisible(true);
		setSize(600,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}
	
	public String getEingabe(){
		return this.send.getText();
	}

	
	/**
	 * Diese Methode gibt die empfangenen Nachrichten in der Textarea aus
	 * @param text die neue Nachricht vom Chatroom
	 */
	public void setTextArea(String text){
		this.rec.setText(this.rec.getText()+"\n"+text);
		this.send.setText("");
		this.rec.setSelectionStart(this.rec.getText().length());
	}
}

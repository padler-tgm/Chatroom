package adler_schwarz.grafik;

import java.awt.*;

import javax.swing.*;

public class GUIChatroom extends JFrame{
	private Controller c;
	private TextArea send,rec;
	private JCheckBox check;
	public GUIChatroom(Controller c){
		this.c = c;
		this.init();
	}

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
	
	public boolean isChecked(){
		if(this.check.isSelected()){
			this.check.setText("Badwords aktivieren");
		}else{
			this.check.setText("Badwords deaktivieren");
		}
		return this.check.isSelected();
	}
}
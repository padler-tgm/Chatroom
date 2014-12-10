package adler_schwarz.file;

import java.io.*;
import java.util.*;

/**
 * Diese Klasse verwaltet das Properties-File wo die Badwords verwaltet werden
 * @author Philipp Adler
 * @author Stefan Schwarz
 *
 * @version 2014-12-10
 */
public class File {
	private Properties prop;
	private OutputStream output;
	private InputStream input;
	private boolean write;
	
	/**
	 * Der Benutzer gibt an ob er in das File schreiben (true) oder lesen möchte (false)
	 * @param write hier wird angegebenen ob gelesen oder geschrieben werden soll
	 */
	public File(boolean write){
		this.write = write;
		this.prop = new Properties();
		try {
			if(write){
				this.output = new FileOutputStream("config.properties");
			}else{
				this.input = new FileInputStream("config.properties");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Schreibt den Inhalt des Arrays in das File
	 * @param eingaben Inhalt des Arrays
	 */
	public void write(String[] eingaben){
		for(String text : eingaben){
			this.setData(text);
		}
	}

	/**
	 * Diese Methode setzt alle Buchstaben der Wörter auf Kleinbuchstaben
	 * @param badword ein Badwort welches in Kleinbuchstaben geschrieben wird
	 */
	public void setData(String badword){
		this.prop.setProperty("badword"+this.getSize(), badword.toLowerCase());
	}

	/**
	 * Liest den Inhalt des File
	 * @return den Inhalt des File
	 */
	public String getData(){
		String liste = "";
		try {
			this.prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i<this.getSize(); i++){
			liste += this.prop.get("badword"+i)+"\n";
		}
		return liste;
	}
	
	/**
	 * Diese Methode überprüft den übergebenen Parameter mit den Badwords
	 * @param text ein Wort welches überprüft wird
	 * @return wenn es sich beim übergebenen Parameter um ein Badword handelt wird true zurück gegeben
	 */
	public boolean isBadWord(String text){
		try {
			this.prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.prop.contains(text);
	}

	/**
	 * Gibt die Anzahl der Badwords im Properties-File zurück
	 * @return Anzahl an Wörter im File
	 */
	private int getSize(){
		try {
			this.prop.load(new FileInputStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.values().size();
	}

	/**
	 * Schließt das File
	 */
	public void close(){
		try {
			if(write){
				this.prop.store(this.output, "Bad Words");
			}else{
				this.input.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
package adler_schwarz.file;

import java.io.*;
import java.util.*;

public class File {
	private Properties prop;
	private OutputStream output;
	private InputStream input;
	private boolean write;
	
	/**
	 * 
	 * @param write
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

	public void setData(String badword){
		this.prop.setProperty("badword"+this.getSize(), badword.toLowerCase());
	}

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
	 * 
	 * @param text
	 * @return
	 */
	public boolean isBadWord(String text){
		try {
			this.prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.prop.contains(text);
	}

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
	 * 
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
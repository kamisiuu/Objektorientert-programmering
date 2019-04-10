package main;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class LargeProdukter {

	private String path;
	private ArrayList<Object> objectList;
	
	
	// Konstruktør
	public LargeProdukter(String path, ArrayList<Object> objectList){
	
		this.path = path;
		this.objectList= objectList;
		writeToSerFile();
	}
	public void writeToSerFile(){
	
		try {
			//åpner strøm til fil
			FileOutputStream outStream = new FileOutputStream(path);
			//åpner objekt strøm til fil
			ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);
			
			// iterere gjennom alle objekter i listen og skrive de til fil 
			
			for(Object obj : objectList){
				objOutStream.writeObject(obj);
			}
			
			// lukker strømmer
			objOutStream.close();
			outStream.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("error: filen finnes ikke");
		} catch (IOException e) {
			System.out.println("Error : kan ikke åpne objektstrøm fil");
		}
	}
}
	
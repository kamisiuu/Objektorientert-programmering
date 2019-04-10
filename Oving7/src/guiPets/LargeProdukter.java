package guiPets;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LargeProdukter {

	private String path;
	private ArrayList<Object> objList;

	// Konstrukt�r
	public LargeProdukter(String path, ArrayList<Object> objList){
		this.path = path;
		this.objList = objList;
		writeToSerFile();
	}
	
	
	private void writeToSerFile(){
		try {
			// �pner str�m til fil
			FileOutputStream outStream = new FileOutputStream(path);
			
			//�pner objekt str�m til fil
			ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);
			
			//iterere gjennom alle objekter i listen og skrive de til fil
			for(Object obj: objList){
				objOutStream.writeObject(obj);
			}
			
			
			// lukker str�mmer
			objOutStream.close();
			outStream.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: filen finnes ikke");
		} catch (IOException e) {
			System.out.println("ERROR: kan ikke �pne objektstr�m til fil");
		}
	}

}

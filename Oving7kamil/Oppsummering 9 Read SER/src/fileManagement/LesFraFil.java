package fileManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import main.Kurs;
import main.Main;
import main.Student;

public class LesFraFil {
	private String path;
	
	// constructor
	public LesFraFil(String path) {
		this.path = path;
		readObjectsFromFile();
	}
	
	//metode for � hente objekter
	private void readObjectsFromFile(){
		try {
			// �pner input str�m fra fil til prog.
			FileInputStream inStream = new FileInputStream(path);
			
			// �pner st�m for lesing av objekt
			ObjectInputStream objInStream = new ObjectInputStream(inStream);
			
			Object o = null;
			
			// g� igjennom alle objekt i filen
			while( (o = objInStream.readObject() ) != null){
				if(o instanceof Kurs){
					Main.getKursListe().add( (Kurs) o );
				}
				else if( o instanceof Student){
					Main.getStudentListe().add( (Student) o );
				}
				else{
					System.out.println("ERROR: hverken fugl eller fisk");
				}
			}
		
			// lukke str�mmer
			objInStream.close();
			inStream.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: filen finnes ikke");
		} catch (IOException e) {
			System.out.println("ERROR: feil p� objektstr�m");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: ingen fler objekt � lese");
		}
	}
	

	// get and set
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}	
}

package main;



import guiPets.PetFrame;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import medlemmer.Leverandor;
import varelager.Fisk;
import varelager.Pattedyr;
import varelager.Reptil;



public class LesFraFil {
	private String path;
	
	
	 
	
	//konstruktør
	public LesFraFil(String path) {
		this.path = path;
		 readObjectsFromFile();
	}
	//metode for å hente objekter
	private void readObjectsFromFile(){
		
		try {
			//åpner input strøm fra fil til prog.
			FileInputStream inStream = new FileInputStream(path);
			// åpner strøm for lesing av objekt
			ObjectInputStream objInStream= new ObjectInputStream(inStream);
			
			Object o = null;
			
			//gå gjennom alle objekt i filen
			while(true){
				try {
					o = objInStream.readObject();
				} catch (EOFException e) {
					break;
				} catch (ClassNotFoundException e) {
				}
				if(o instanceof Leverandor){
					PetFrame.getLeverandorList().add( (Leverandor) o );
				}else if( o instanceof Fisk){
					PetFrame.getFiskList().add( (Fisk) o );
				}else if( o instanceof Pattedyr){
					PetFrame.getPattedyrList().add( (Pattedyr) o );
				}else if( o instanceof Reptil){
					PetFrame.getReptilList().add( (Reptil) o );
				}else{
					System.out.println("ERROR: ikke noe lagret ");
				}
			}
			
			//lukker strømene
			
			objInStream.close();
			inStream.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error:filen finnes ikke");
		} catch (IOException e) {
			System.out.println("Error:feil på objektstrøm" + e);
			
			
		} 
		}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
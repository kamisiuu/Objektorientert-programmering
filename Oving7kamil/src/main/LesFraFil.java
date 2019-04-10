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
	
	
	 
	
	//konstrukt�r
	public LesFraFil(String path) {
		this.path = path;
		 readObjectsFromFile();
	}
	//metode for � hente objekter
	private void readObjectsFromFile(){
		
		try {
			//�pner input str�m fra fil til prog.
			FileInputStream inStream = new FileInputStream(path);
			// �pner str�m for lesing av objekt
			ObjectInputStream objInStream= new ObjectInputStream(inStream);
			
			Object o = null;
			
			//g� gjennom alle objekt i filen
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
			
			//lukker str�mene
			
			objInStream.close();
			inStream.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error:filen finnes ikke");
		} catch (IOException e) {
			System.out.println("Error:feil p� objektstr�m" + e);
			
			
		} 
		}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
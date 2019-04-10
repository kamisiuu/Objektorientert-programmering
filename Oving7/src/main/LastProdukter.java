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

public class LastProdukter {
	private String path;
	
	
	 
	
	//konstrukt�r
	public LastProdukter(String path) {
		this.path = path;
		readObjectsFromFile();
		
	}
	
	// Leser for og hente frs objekter
	private void readObjectsFromFile(){
		try {
			//�pner input str�m fra fil til prog
			FileInputStream inStream = new FileInputStream(path);
			
		
			//�pner str�m for lesiong av object
			ObjectInputStream objInStream = new ObjectInputStream(inStream);
			
			//
			Object o = null;
			
			// g� igjennom alle objekt i filen
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
			
			//lukker str�m
			objInStream.close();
			inStream.close();
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: filen ikke");
			
		} catch (IOException e) {
			System.out.println("ERROR: feil p� objektstr�m " + e);
			
		}
		
		
	}
	
	
//	

	//get og set
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}	
	
}
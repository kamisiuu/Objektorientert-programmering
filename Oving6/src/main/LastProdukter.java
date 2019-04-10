package main;
import guiPets.PetFrame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import medlemmer.Leverandor;
import varelager.Fisk;
import varelager.Pattedyr;
import varelager.Reptil;

public class LastProdukter {
	private String path;
	private BufferedReader bReader;
	
	 
	
	//konstruktør
	public LastProdukter(String path) {
		this.path = path;
		lesData();
	}
	
	private void lesData(){
		try {
			//sette opp lesestrøm fra fil
			FileReader fReader = new FileReader(path); 
			
			bReader = new BufferedReader(fReader);
			
			// definere linje-variabel
			String line;
	
			
			/*
			 * 	while løkke som går igjennom hver linje så lenge 
			 * 	linje(bReader.readLine()) ikke er lik null
			 */
			
			while((line = bReader.readLine()) != null){
				//sende linje til spiltLine metoden og få tilbake en array
				String[] splitLine = splitLine(line);
				
				
				//sjekk objekttypen i arrayens første posisjon og benytt passende metode
				switch(splitLine[0]){
					case "leverandor":
						mapLeverandor(splitLine);
						break;
					case "fisk":
						mapFisk(splitLine);
						break;
					case "pattedyr":
						mapPattedyr(splitLine);
						break;
					case "reptil":
						mapReptil(splitLine);
						break;
				}
			}
		// fang feilmeldinger	
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: fant ikke filen"); 
		} catch (IOException e) {
			System.out.println("ERROR: feil på strømmen");
		}
	}
	
	/*
	 * metode som tar imot en string og deler denne på tegnet ";" 
	 * og returnerer en String array
	 */
	
	private String[] splitLine(String line){
		String[] returnArray = line.split("¤");
		return returnArray;
	}
	
	
	
	
	//metode for å legge til fisk
	private void mapFisk(String[] splitLine){
		//Lager variabler med verdi fra Array
		String produktnavn = splitLine[1];
		double inkjPris = Double.parseDouble(splitLine[2]);
		double pris = Double.parseDouble(splitLine[3]);
		Leverandor lev = getLeverandor(splitLine[4]); 
		String slektsnavn = splitLine[5]; 
		String artsnavn =  splitLine[6];
		
		
		PetFrame.getFiskList().add(
				
				//opprett nytt objekt av fisk her og bruk verdiene fra lineSplit arrayen
				new Fisk(produktnavn, inkjPris, pris, lev, slektsnavn, artsnavn) 
				);
		
	}
	
	//metode for å legge til leverandører
	private void mapLeverandor(String[] splitLine){
		
		//Lager variabler med verdi fra Array
		String navn = splitLine[1];
		String epost = splitLine[2];
		String adr = splitLine[3];
		int pnr = Integer.parseInt(splitLine[4]); 
		String psted = splitLine[5]; 
		int tlf =  Integer.parseInt(splitLine[6]);
		
		
		PetFrame.getLeverandorList().add(
				//opprett nytt objekt av leverandør her og bruk verdiene fra lineSplit arrayen
				
				new Leverandor(navn, epost, adr, pnr, psted, tlf)
				);
	}
	
	//metode for å legge til pattedyr
	private void mapPattedyr(String[] splitLine){
		
		//Lager variabler med verdi fra Array
		String produktnavn = splitLine[1];
		double inkjPris = Double.parseDouble(splitLine[2]);
		double pris = Double.parseDouble(splitLine[3]);
		Leverandor lev = getLeverandor(splitLine[4]); 
		String slektsnavn = splitLine[5]; 
		String artsnavn =  splitLine[6];
		
		PetFrame.getPattedyrList().add(
				//opprett nytt objekt av pattedyr her og bruk verdiene fra lineSplit arrayen

			
				new Pattedyr(produktnavn, inkjPris, pris, lev, slektsnavn, artsnavn)
				);
	}
	
	//metode for å legge til reptiler
	private void mapReptil(String[] splitLine){

		//Lager variabler med verdi fra Array
		String produktnavn = splitLine[1];
		double inkjPris = Double.parseDouble(splitLine[2]);
		double pris = Double.parseDouble(splitLine[3]);
		Leverandor lev = getLeverandor(splitLine[4]); 
		String slektsnavn = splitLine[5]; 
		String artsnavn =  splitLine[6];
		
		
		PetFrame.getReptilList().add(
				//opprett nytt objekt av reptil her og bruk verdiene fra lineSplit arrayen
				
				new Reptil(produktnavn, inkjPris, pris, lev, slektsnavn, artsnavn)
				);
	}
	
	
	//metode for å finne leverandoer objekt
	private Leverandor getLeverandor(String name){
		for(Leverandor lev : PetFrame.getLeverandorList()){
			if(lev.getNavn().equals(name)){
				return lev;
			}
		}
		return null;
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
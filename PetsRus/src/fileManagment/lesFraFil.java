package fileManagment;

import gui.MainFrame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import varelager.Fisk;

public class lesFraFil {
	
	private String path;
	
	private String cmd;
	private static int pris;
	private static int inkjPris;
	//konstroktør
	public lesFraFil(String path, String cmd) {
		
		this.path = path;
		this.cmd = cmd;
		checkCmd();
	}
	// metode for å sjekke komando
	
	private void checkCmd(){
		switch(cmd){
		case("fisk"):
			// hente fisk fra fil
			readFishes();
			break;
		case("reptil"):
			// hente reptil fra fil
			 readReptils();
			break;
		case("pattedyr"):
			// hente pattedyr fra fil
			readPattedyrs();
			break;
		default:
			System.out.println("ERROR: feil kommando");
		}
	}
	// metode for å hente fisker
	private void readFishes(){
		try {// oppretter lesestrøm fra fil 
			FileReader freader= new FileReader(path);
			// oppretter lesebuffer fra fil
			BufferedReader fbreader= new BufferedReader(freader);
		// oppretter string variabel for hver linje 
			String line;
			// while-løkke for å lese filer
			
			while ((line = fbreader.readLine()) != null) {
				// lager stringarray og fyller den med resultatet av splitt
				String [] splittlinje = line.split("¤");
				inkjPris=Integer.parseInt(splittlinje[1]);
				 pris=Integer.parseInt(splittlinje[2]);
				String produktnavn=splittlinje[0];
			
				
				String slektsnavn=splittlinje[3];
				String artsnavn= splittlinje[4];

			
				//new Fisk(produktnavn, inkjPris, pris, leverandor, slektsnavn, artsnavn)
				int length= splittlinje.length;
				MainFrame.getFishen().add(new Fisk(produktnavn, inkjPris, pris, slektsnavn, artsnavn));
				if(length != 5){
					for(int i =5; i < length; i++){
						// finne leverandorobjekt i systemet vårt
						
					}
					
					
				}
			}
			// lukker strømmen
			
			freader.close();
			fbreader.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			System.out.println("feil melding");
		}
	}
	// metode for å hente reptiler
	private void readReptils(){
		
	}
	// metode for å hente pattedyr
	private void readPattedyrs(){
		
	}
	//getters and setters
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	
	
	
}

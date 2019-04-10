package fileManagment;

import gui.MainFrame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import medlemmer.Leverandor;
import varelager.Fisk;
import varelager.Pattedyr;
import varelager.Reptil;

public class skrivTilFil {
	private String path;
	private String cmd;
	
	//konstroktør
	public skrivTilFil(String path,String cmd){
		
		this.path=path;
		this.cmd=cmd;
		//den sjekker kommandoen,/ kjører den
		checkCmd();
	}
	//metode sjekker kommando
	private void checkCmd(){
		
		switch(cmd){
		case("fisk"):
			writeFishes();
			break;
		case("reptil"):
			writeReptils();
			break;
		case("pattedyr"):
			writePattedyr();
			break;
		default:
			System.out.println("ERROR: feil kommando");
		}
	}
	//metode for å skrive fisker til fil
	private void writeFishes(){
		try {
			//oppretter skrivestrøm til fil 
			FileWriter fwriter= new FileWriter(path);
			
			//oppretter bufferstrøm til fil
			BufferedWriter bwriter= new BufferedWriter(fwriter);
			
			// gå gjennom alle Fishenobjekter i lista
			for(Fisk f: MainFrame.getFishen()){
				// oppretter variabler med verdier fra Fishenobjektet
				//Fisk f= new Fisk(produktnavn, inkjPris, pris, leverandor, slektsnavn, artsnavn)
				
				String produktnavn =f.getProduktnavn();
				double inkjPris=f.getInkjPris();
				double pris=f.getPris();
				// mangler Leveraandor
				String slektsnavn=f.getSlektsnavn();
				String artsNavn = f.getArtsnavn();
				Leverandor lev = (Leverandor)f.getLeverandor();
				// skriv ny linje til fil
				bwriter.write(produktnavn+"¤"+inkjPris+"¤"+pris+"¤"+lev+"¤"+slektsnavn+"¤"+artsNavn+"\n");
			}
				// stenger strømmen 
				bwriter.close();
				fwriter.close();
				
		} catch (IOException e) {
		System.out.println(e);
		}
	}
	//metode for å skrive reptiler til fil
	private void writeReptils(){
		try{
			//oppretter Skrivestrøm til fil
			FileWriter rwriter= new FileWriter(path);
			//oppretter bufferstrøm til fil 
			BufferedWriter rbwriter= new BufferedWriter(rwriter);
			//gå gjennom alle Reptilobjektene i lista
			for(Reptil r: MainFrame.getReptilensen()){
				// oppretter variabler med verdier for REptilobjektene
				String produktnavn =r.getProduktnavn();
				double inkjPris=r.getInkjPris();
				double pris=r.getPris();
				// mangler Leveraandor
				String slektsnavn=r.getSlektsnavn();
				String artsNavn = r.getArtsnavn();
				Leverandor lev = (Leverandor)r.getLeverandor();
				// skriv ny linje til fil
				rbwriter.write(produktnavn+"¤"+inkjPris+"¤"+pris+"¤"+lev+"¤"+slektsnavn+"¤"+artsNavn+"\n");
			}
				// stenger strømmen 
				rbwriter.close();
				rwriter.close();
				
		} catch (IOException e) {
		System.out.println(e);
		}
	}
				
			
	
	//metode for å skrive pattedyr til fil 
	private void writePattedyr(){
		try{ // her oppretter vi skrivestrøm til fil
			FileWriter pwriter = new FileWriter(path);
			// oppretter bufferstrøm til fil
			BufferedWriter pbwriter= new BufferedWriter(pwriter);
			// gå gjennom alle objektene i pattedyrlista
			for( Pattedyr p: MainFrame.getPattedyrensen()){
				String produktnavn =p.getProduktnavn();
				double inkjPris=p.getInkjPris();
				double pris=p.getPris();
				// mangler Leveraandor
				String slektsnavn=p.getSlektsnavn();
				String artsNavn = p.getArtsnavn();
				Leverandor lev = (Leverandor)p.getLeverandor();
				// skriv ny linje til fil
				pbwriter.write(produktnavn+"¤"+inkjPris+"¤"+pris+"¤"+lev+"¤"+slektsnavn+"¤"+artsNavn+"\n");
			}
			// stenger strømmen 
			pbwriter.close();
			pwriter.close();
			
			} catch (IOException e) {
				System.out.println(e);
			 }
		}
}
		

package guiPets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import medlemmer.Leverandor;
import varelager.Fisk;
import varelager.Pattedyr;
import varelager.Reptil;

public class LargeProdukter {

	private String path;
	private String cmd;
	
	
	// Konstrukt�r
	public LargeProdukter(String path, String cmd){
		this.cmd = cmd;
		this.path = path;
		checkCmd();
	}
	
	
	// Sjekker kommando
	private void checkCmd(){
		
		switch(cmd){
			case("Fisk"):
				// kj�r skrive metode for Fisk
				WriteFisk();
				break;
			case("Reptil"):
				//kj�r skrive metode for Reptil
				WriteReptil();
				break;
			case("Pattedyr"):
				// kj�r skrive metode for Pattedyr
				WritePattedyr();
				break;
			case("Leverandor"):
				// kj�r skrive metode for Pattedyr
				WriteLeverandor();
				break;
				
			default:
				System.out.println("ERROR: Feil Kommando");
		}
	}
	// Metode for � skrive til fil Fisk
	private void WriteFisk(){
		try {
			// opretter skrivestr�m til fil
			FileWriter fWriter = new FileWriter(path);
			
			// opretter en bufferstr�m til fil
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			
			// G� igjennom alle Fiskobjekter i fiskelisten
			for(Fisk f : PetFrame.getFiskList()){
				// Oppretter variabler med verdier fra kursobjekt
				String produktnavn = f.getProduktnavn();
				double inkjPris = f.getInkjPris();
				double pris = f.getPris();
				String leverandor = f.getLeverandor().getNavn();
				String slektsnavn = f.getSlektsnavn(); 
				String artsnavn = f.getArtsnavn();
				
				
				
				bWriter.write("fisk�"+produktnavn + "�" + inkjPris + "�" + pris + "�" + leverandor + "�" + slektsnavn + "�" + artsnavn + "\n");
			}
			
			// Lukker str�mmen 
			bWriter.close();
			fWriter.close();
			
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	// Metode for � skrive til fil Reptil
	private void WriteReptil(){
		try {
			// opretter skrivestr�m til fil
			FileWriter rWriter = new FileWriter(path);
			
			// opretter en bufferstr�m til fil
			BufferedWriter bWriter = new BufferedWriter(rWriter);
			
			// G� igjennom alle Fiskobjekter i fiskelisten
			for(Reptil r : PetFrame.getReptilList()){
				// Oppretter variabler med verdier fra kursobjekt
				
				String produktnavn = r.getProduktnavn();
				double inkjPris = r.getInkjPris();
				double pris = r.getPris();
				String leverandor = r.getLeverandor().getNavn();
				String slektsnavn = r.getSlektsnavn(); 
				String artsnavn = r.getArtsnavn();
				
				
				
				bWriter.write("reptil�" + produktnavn + "�" + inkjPris + "�" + pris + "�" + leverandor + "�" + slektsnavn + "�" + artsnavn + "\n");
			}
			
			// Lukker str�mmen 
			bWriter.close();
			rWriter.close();
			
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	private void WritePattedyr(){
		try {
			// opretter skrivestr�m til fil
			FileWriter pWriter = new FileWriter(path);
			
			// opretter en bufferstr�m til fil
			BufferedWriter bWriter = new BufferedWriter(pWriter);
			
			// G� igjennom alle Fiskobjekter i fiskelisten
			for(Pattedyr p : PetFrame.getPattedyrList()){
				// Oppretter variabler med verdier fra kursobjekt
				
				String produktnavn = p.getProduktnavn();
				double inkjPris = p.getInkjPris();
				double pris = p.getPris();
				String leverandor = p.getLeverandor().getNavn();
				String slektsnavn = p.getSlektsnavn(); 
				String artsnavn = p.getArtsnavn();
				
				
				
				bWriter.write("pattedyr�" + produktnavn + "�" + inkjPris + "�" + pris + "�" + leverandor + "�" + slektsnavn + "�" + artsnavn + "\n");
			}
			
			// Lukker str�mmen 
			bWriter.close();
			pWriter.close();
			
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void WriteLeverandor(){
		try {
			// opretter skrivestr�m til fil
			FileWriter lWriter = new FileWriter(path);
			
			// opretter en bufferstr�m til fil
			BufferedWriter bWriter = new BufferedWriter(lWriter);
			
			// G� igjennom alle Fiskobjekter i fiskelisten
			for(Leverandor l : PetFrame.getLeverandorList()){
				// Oppretter variabler med verdier fra kursobjekt
				
				String navn = l.getNavn();
				String epost = l.getEpost();
				String adr = l.getAdr();
				int pnr = l.getPnr();
				String psted = l.getPsted();
				int tlf = l.getTlf();
				
				bWriter.write("leverandor�" + navn + "�" + epost + "�" + adr + "�" + pnr + "�" + psted + "�" + tlf + "\n");
			}
			
			// Lukker str�mmen 
			bWriter.close();
			lWriter.close();
			
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

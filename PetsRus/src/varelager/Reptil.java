package varelager;

import medlemmer.Leverandor;

public class Reptil extends LevendeProdukt {
	//her har jeg satt antReptiler til 0 , for det er startverdien
	private static int antReptiler=0;
	
	// funksjonen solgt gjør at når vi selger noe så minker antReptiler
	public void solgt(){
		antReptiler--;
		
		//her arver solgt fra Levendeprodukt
		super.solgt();
	}
	//konstroktør

	public Reptil(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor,
			String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor,
				 slektsnavn, artsnavn);
		// her starter vi med ++ for vi oppretter objektet med konstroktøren 
		antReptiler++;
		
	}
// her har jeg bare getter for antReptiler 
	public static int getAntReptiler() {
		return antReptiler;
	}
	public String toString(){
		return getProduktnavn();
	}
	

	
	
}

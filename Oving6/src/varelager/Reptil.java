package varelager;

import medlemmer.Leverandor;

public class Reptil extends LevendeProdukt {
	
	private static int antReptiler = 0;

	/* Getter og setter */
	public int getAntReptiler() {
		return antReptiler;
	}
	
	public String toString(){
		return getProduktnavn();
	}

	
	
	/* metoder */
	public void solgt(){
		antReptiler--;
		
		super.solgt();
	}

	/* constructor */
	public Reptil(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor,
			String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor, slektsnavn, artsnavn);
		
		antReptiler++;
	}
	
	
	
}

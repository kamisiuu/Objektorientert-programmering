package varelager;

import medlemmer.Leverandor;

public class Pattedyr extends LevendeProdukt {

	private static int antPatteDyr = 0;

	
	/* Getter og setter */
	public int getAntPatteDyr() {
		return antPatteDyr;
	}
	
	
	public String toString(){
		return getProduktnavn();
	}


	/* metoder */
	public void solgt(){
		antPatteDyr--;
		super.solgt();
	}

	/* Her lager vi en constructor for Pattedyr */
	
	
	public Pattedyr(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor,
			String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor, slektsnavn, artsnavn);
		
		antPatteDyr++;
	}

	
	
}

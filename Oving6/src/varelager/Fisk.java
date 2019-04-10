package varelager;

import medlemmer.Leverandor;

public class Fisk extends LevendeProdukt{

	private static int antFisker = 0;
	
	
	/* Getter og setter */
	public static int getAntFisker() {
		return antFisker;
	}
	
	public String toString(){
		return getProduktnavn();
	}

	
	
	/* metoder  */
	public void solgt(){
		antFisker--;
		
		super.solgt();
	}
	

	
	/* Her lager vi en constructor for Fisk */
	
	public Fisk(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor, String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor, slektsnavn, artsnavn);
		antFisker++;
	}
		
	
}

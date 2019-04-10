package varelager;

import medlemmer.Leverandor;

public class Fisk extends LevendeProdukt {

	private static int antFisker=0;
	
	public void solgt(){
		antFisker--;
		super.solgt();
	}
	//konstroktør med getters og setters utenom setters for ant for å ikke lagre noe verdi inn i den ,
		//den lagres i objektet når vi skaper objektet

	public Fisk(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor,String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor,slektsnavn, artsnavn);
		
		antFisker++;
	}
	public Fisk(String produktnavn, double inkjPris, double pris
			,String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris,null, slektsnavn, artsnavn);
		
		antFisker++;
	}

		
	
	public static int getAntFisker() {
		return antFisker;
	}
	public String toString(){
		return getProduktnavn();
	}
	
	
	
}

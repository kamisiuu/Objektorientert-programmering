package varelager;

import medlemmer.Leverandor;


public class Pattedyr extends LevendeProdukt  {

	private static int antPatteDyr=0;
	
	public void solgt(){
		antPatteDyr--;
		super.solgt();
	}

	public Pattedyr(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor,String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor,
				 slektsnavn, artsnavn);
		


		antPatteDyr++;
	}

	public static int getAntPatteDyr() {
		return antPatteDyr;
	}
	public String toString(){
		return getProduktnavn();
	}
}

	
	


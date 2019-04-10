package varelager;

import java.io.Serializable;

import medlemmer.Leverandor;

public class Pattedyr extends LevendeProdukt implements Serializable {


	private static final long serialVersionUID = 1L;
	private static int antPatteDyr = 0;

	
	/* Getter og setter */
	public static int getAntPatteDyr() {
		return antPatteDyr;
	}
	
	
	public String toString(){
		return getProduktnavn()+""+ getPris();
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

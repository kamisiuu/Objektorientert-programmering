package varelager;

import java.io.Serializable;

import medlemmer.Leverandor;

public class Reptil extends LevendeProdukt implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int antReptiler = 0;

	/* Getter og setter */
	public static  int getAntReptiler() {
		return antReptiler;
	}
	
	public String toString(){
		return getProduktnavn() + " "+ getPris();
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

package varelager;

import java.io.Serializable;

import medlemmer.Leverandor;

public class Fisk extends LevendeProdukt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5656768787536036872L;
	
	
	
	/* Getter og setter */
	
	
	public String toString(){
		return getProduktnavn();
	}


	
	/* Her lager vi en constructor for Fisk */
	
	public Fisk(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor, String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor, slektsnavn, artsnavn);
		
	}
		
	
}

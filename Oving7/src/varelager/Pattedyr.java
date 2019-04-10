package varelager;

import java.io.Serializable;

import medlemmer.Leverandor;

public class Pattedyr extends LevendeProdukt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8977611837626810579L;

	
	
	public String toString(){
		return getProduktnavn();
	}



	/* Her lager vi en constructor for Pattedyr */
	
	
	public Pattedyr(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor,
			String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor, slektsnavn, artsnavn);
	}

	
	
}

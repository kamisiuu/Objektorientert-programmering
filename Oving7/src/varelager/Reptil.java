package varelager;

import java.io.Serializable;

import medlemmer.Leverandor;

public class Reptil extends LevendeProdukt implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5094994757805649427L;

	
	public String toString(){
		return getProduktnavn();
	}



	/* constructor */
	public Reptil(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor,
			String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor, slektsnavn, artsnavn);
	}
	
	
	
}

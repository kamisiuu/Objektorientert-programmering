package varelager;

import medlemmer.Leverandor;


// er superklassen til Produkt og subklassen til fisk, pattedyr og reptil
// her arver vi fra Produkt
public class LevendeProdukt extends Produkt {
	// vi setter antLevendeProdukter til 0 
	private static int antLevendeProdukter=0;
	private String slektsnavn;
	private String artsnavn;
	
	public void solgt(){
		
		// antLevendeProdukter -- betyr at den går en mindre når vi selger den
		antLevendeProdukter--;
		
		//her arver vi metoden solgt fra produkt
		super.solgt();
	}


	public LevendeProdukt(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor,String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor);
		
		this.slektsnavn = slektsnavn;
		this.artsnavn = artsnavn;
		antLevendeProdukter++;
		
	}


	public static int getAntLevendeProdukter() {
		return antLevendeProdukter;
	}
	
	public String getSlektsnavn() {
		return slektsnavn;
	}

	public void setSlektsnavn(String slektsnavn) {
		this.slektsnavn = slektsnavn;
	}

	public String getArtsnavn() {
		return artsnavn;
	}

	public void setArtsnavn(String artsnavn) {
		this.artsnavn = artsnavn;
	}
	
	
}

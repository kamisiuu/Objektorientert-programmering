package varelager;

import medlemmer.Leverandor;

/* Arver fra klassen Produkt */ 
public class LevendeProdukt extends Produkt {

	/* deklarasjon av variabler og typer */
	
	private static int antLevendeProdukter = 0;
	private String slektsnavn;
	private String artsnavn;
	
	
	/* Getters og setters for variabler og typer */
	
	public int getAntLevendeProdukter() {
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
	
	
	/* Her deklarer vi metodene */
	public void solgt(){
		antLevendeProdukter--;
		
		super.solgt();
		
	}
	
	
	/* Her lager vi en constructor for LevendeProdukt */
	
	public LevendeProdukt(String produktnavn, double inkjPris, double pris, Leverandor leverandor,
			String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandor);
		antLevendeProdukter++;
		this.slektsnavn = slektsnavn;
		this.artsnavn = artsnavn;
		
	}

	
	
}

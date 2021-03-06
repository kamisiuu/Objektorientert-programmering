package varelager;

import medlemmer.Leverandor;

/* Arver fra klassen Proukt */
public class Artikkel extends Produkt{
	
	

	private static final long serialVersionUID = 4656026634362698491L;
	/* Deklarerer alle variabler og typer */
	private static int antArtikkel = 0;
	private int antIartikkel;
	
	/*Getters og setters for variabler og typer  */
	
	public int getAntArtikkel() {
		return antArtikkel;
	}



	public int getAntIartikkel() {
		return antIartikkel;
	}



	public void setAntIartikkel(int antIartikkel) {
		this.antIartikkel = antIartikkel;
	}

	/* metoder */

	public void solgt(){
		antArtikkel--;
		
		super.solgt();
	}

	/* constructor av klassen Artikkel */

	public Artikkel(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor, int antIartikkel) {
		super(produktnavn, inkjPris, pris, leverandor);
		antArtikkel++;
		this.antIartikkel = antIartikkel;
	}
	

}

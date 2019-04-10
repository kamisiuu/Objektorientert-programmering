package varelager;

/* Her importerer vi classen Levrandor fra  */
/* fra pakken medlemmer */

import medlemmer.Leverandor;

public class Produkt {
	
	
	/* Her deklarer vi typer og variabler */
	
	private String produktnavn;
	private double inkjPris;
	private double pris;
	private Leverandor leverandor;
	private static int antProdukter = 0;
	
	
	/* Her kommer getters og setters for alle  */
	/* variabler og typer i classen Produkt */
	
	public String getProduktnavn() {
		return produktnavn;
	}

	public void setProduktnavn(String produktnavn) {
		this.produktnavn = produktnavn;
	}

	public double getInkjPris() {
		return inkjPris;
	}

	public void setInkjPris(int inkjPris) {
		this.inkjPris = inkjPris;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public Leverandor getLeverandor() {
		return leverandor;
	}

	public void setLeverandor(Leverandor leverandor) {
		this.leverandor = leverandor;
	}

	public static int getAntProdukter() {
		return antProdukter;
	}

	

	
	
	/* Her bli metodene deklarert  */
	
	public void solgt(){
		antProdukter--;
		
	}

	
	/* Her er constructor for klassen Produkt */
	public Produkt(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor) {
		this.produktnavn = produktnavn;
		this.inkjPris = inkjPris;
		this.pris = pris;
		this.leverandor = leverandor;
		antProdukter++;
	}
	

}

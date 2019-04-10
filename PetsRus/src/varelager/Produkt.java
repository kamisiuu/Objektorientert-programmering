package varelager;

import medlemmer.Leverandor;

public class Produkt {

	private String produktnavn;
	private double inkjPris;
	private double pris;
	private Leverandor leverandor ;
	private static int antProdukter=0;
	
	
	public void solgt(){
		antProdukter--;
		
		
	
	}
	//konstroktør
	public Produkt(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor) {
		
		this.produktnavn = produktnavn;
		this.inkjPris = inkjPris;
		this.pris = pris;
		this.leverandor = leverandor;
		
		antProdukter++;
	}
	
	//getters and setters
	public static int getAntProdukter() {
		return antProdukter;
	}
	public String getProduktnavn() {
		return produktnavn;
	}
	public void setProduktnavn(String produktnavn) {
		this.produktnavn = produktnavn;
	}
	public double getInkjPris() {
		return inkjPris;
	}
	public void setInkjPris(double inkjPris) {
		this.inkjPris = inkjPris;
	}
	public double getPris() {
		return pris;
	}
	public void setPris(double pris) {
		this.pris = pris;
	}
	public Leverandor getLeverandor() {
		return leverandor;
	}
	public void setLeverandor(Leverandor leverandor) {
		this.leverandor = leverandor;
	}
	
	
}

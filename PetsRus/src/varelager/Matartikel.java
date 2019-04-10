package varelager;

import java.util.Date;

import medlemmer.Leverandor;

public class Matartikel extends Artikel{

	private int antMatartikler;
	private Date bestFoer;
	
	public void solgt(){
		
	}
	//konstroktør

	public Matartikel(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor,
			 int antMatartikler, Date bestFoer) {
		super(produktnavn, inkjPris, pris, leverandor);
		this.antMatartikler = antMatartikler;
		this.bestFoer = bestFoer;
	}

	public Date getBestFoer() {
		return bestFoer;
	}

	public void setBestFoer(Date bestFoer) {
		this.bestFoer = bestFoer;
	}

	public int getAntMatartikler() {
		return antMatartikler;
	}

	
	
}

package varelager;

import java.util.Calendar;

import medlemmer.Leverandor;

public class Matartikkel extends Artikkel {

	/* deklarerer typer og variabler */
	private static int antMatartikkler = 0;
	private Calendar bestFoer;
	
	/* Getters og Setters */
	public int getAntMatartikkler() {
		return antMatartikkler;
	}

	public Calendar getBestFoer() {
		return bestFoer;
	}
	public void setBestFoer(Calendar bestFoer) {
		this.bestFoer = bestFoer;
	}
	
	/* Metoder  */
	
	public void solgt(){
		antMatartikkler--;
		
		super.solgt();
	}
	
	
	/* Constructor for klassen Matartikkel */
	public Matartikkel(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor, int antIartikkel, Calendar bestFoer) {
		super(produktnavn, inkjPris, pris, leverandor, antIartikkel);
		antMatartikkler++;
		this.bestFoer = bestFoer;
	}
	
	
}

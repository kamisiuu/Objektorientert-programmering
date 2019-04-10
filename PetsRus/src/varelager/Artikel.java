package varelager;

import medlemmer.Leverandor;
// arver klassen til Produkt 
public class Artikel extends Produkt {

	private int antArtikler;
	
	
	public void solgt(){
		// antArtikler minker med 1 for hver gang når den blir solgt
		antArtikler--;
		// jeg bruker superklassen 
		super.solgt();
	}
	//konstroktør med getters og setters utenom setters for antall for å ikke lagre noe verdi inn i den ,
	//den lagres i objektet når vi skaper objektet

	public Artikel(String produktnavn, double inkjPris, double pris,
			Leverandor leverandor) {
		super(produktnavn, inkjPris, pris, leverandor);
		antArtikler ++;
	
	}

	public int getAntArtikler() {
		return antArtikler;
	}

	

	
	
}

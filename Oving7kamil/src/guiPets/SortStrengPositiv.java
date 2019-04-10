package guiPets;

import java.util.Comparator;

import varelager.Produkt;

public class SortStrengPositiv implements Comparator<Produkt> {

	@Override
	public int compare(Produkt tall1, Produkt tall2) {
		//sjekekr om tall1 er større enn tall2 hvis ja så skal tall1 stå før tall2
		return tall1.getProduktnavn().compareTo(tall2.getProduktnavn());	
	}

}

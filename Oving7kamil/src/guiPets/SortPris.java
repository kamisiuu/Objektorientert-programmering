package guiPets;

import java.util.Comparator;

import varelager.Produkt;

public class SortPris implements Comparator<Produkt> {

	@Override
	public int compare(Produkt fisk1, Produkt fisk2) {
		//sjekekr om tall1 er st�rre enn tall2 hvis ja s� skal tall1 st� f�r tall2
		if(fisk1.getPris() >fisk2.getPris()){
			return 1;
			
		}if(fisk1.getPris() < fisk2.getPris()){
			return -1;
		}
		return 0;
	}

}

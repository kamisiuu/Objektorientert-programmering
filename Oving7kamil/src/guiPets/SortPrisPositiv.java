package guiPets;

import java.util.Comparator;

import varelager.Produkt;

public class SortPrisPositiv implements Comparator<Produkt> {

	@Override
	public int compare(Produkt fisk1, Produkt fisk2) {
		//sjekekr om tall1 er større enn tall2 hvis ja så skal tall1 stå før tall2
		if(fisk2.getPris() >fisk1.getPris()){
			return 1;
			
		}if(fisk2.getPris() < fisk1.getPris()){
			return -1;
		}
		return 0;
	}

}

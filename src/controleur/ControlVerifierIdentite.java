package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		Gaulois nom;
		nom= village.trouverHabitant(nomVendeur);
		if(nom != null) {
			return true;
		}
		else {
			return false;
		}
	}
}



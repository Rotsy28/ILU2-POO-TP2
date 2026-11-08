package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		if (village.rechercherEtalVide()) {
			return true;
		}else {
			return false;
		}
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		int numeroEtal = -1;
		Gaulois nom;
		nom = village.trouverHabitant(nomVendeur);
		numeroEtal= village.installerVendeur(nom,produit,nbProduit);
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		if (controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			return true;
		} else {
			return false;
		}
	}
}

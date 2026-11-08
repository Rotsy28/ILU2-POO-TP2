package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] acheterProduit(String nomAcheteur, String nomVendeur,
            String produit, int quantiteAcheter) {
		Gaulois[] vendeursproduits=village.rechercherVendeursProduit(produit);
		Etal etal= controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int stock;
		if (controlVerifierIdentite.verifierIdentite(nomAcheteur) == true) {
			if(vendeursproduits != null) {
				if (controlVerifierIdentite.verifierIdentite(nomVendeur) == true) {
					stock = etal.getQuantite();
					etal.acheterProduit(quantiteAcheter);
				}
				
			}
		}
	}
	
	
}

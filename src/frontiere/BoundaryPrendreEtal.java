package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut etre un "
					+ "habitant de notre village pour commercer ici.");
		}else {
			System.out.println("Bonjour " + nomVendeur + " ,je vais regarder"
					+ " si je peux vous trouver un etal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé " + nomVendeur + " je n'ai plus d'étal"
						+ " qui ne soit déjà occupé.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		String produit;
		int nbProduit;
		int numeroetal;
		System.out.println("C'est parfait, il me reste un étal pour vous!");
		System.out.println("Il me faudra quelques renseignements:");
		StringBuilder question1 = new StringBuilder();
		question1.append("Quel produit souhaitez-vendre?");
		produit = Clavier.entrerChaine(question1.toString());
		StringBuilder question2 = new StringBuilder();
		question2.append("Combien souhaitez-vous en vendre?");
		nbProduit = Clavier.entrerEntier(question2.toString());
		numeroetal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroetal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n° "
					+ numeroetal);
		}
	}
	
}

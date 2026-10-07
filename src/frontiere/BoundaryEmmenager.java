package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					int force=0;
					//TODO a completer
					System.out.println("Bienvenue druide" + nomVisiteur);
					StringBuilder question4 = new StringBuilder();
					question4.append("Quelle est votre force?");
					force = Clavier.entrerEntier(question4.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//TODO a completer
		int forceDruide = 0;
		int effetPotionMin=0;
		int effetPotionMax=0;
		
		System.out.println("Bienvenue druide" + nomVisiteur);
		StringBuilder question1 = new StringBuilder();
		question1.append("Quelle est votre force?");
		forceDruide = Clavier.entrerEntier(question1.toString());
		
		do {
			StringBuilder question2 = new StringBuilder();
			question2.append("Quelle est la force de potion la plus faible que vous produisez?");
			effetPotionMin = Clavier.entrerEntier(question2.toString());
			
			StringBuilder question3 = new StringBuilder();
			question3.append("Quelle est la force de potion la plus forte que vous produisez?");
			effetPotionMax = Clavier.entrerEntier(question3.toString());
			
			if ( effetPotionMax< effetPotionMin) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum "
						+ "et le maximum");
			}
		} while ( effetPotionMax< effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}

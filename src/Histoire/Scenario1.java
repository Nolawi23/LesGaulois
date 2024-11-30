package Histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Musee;
import personnages.Romain;
import personnages.Musee;

public class Scenario1 {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0 && minus.getVainqueur()==false);
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0 && milexcus.getVainqueur());
		Musee musee = new Musee();
		asterix.faireUneDonnation(musee);
		System.out.println(musee.extraireInstructionsOCaml());
		
		
//		Partie a decommenter
		
		Musee musee1 = new Musee();
		asterix.faireUneDonnation(musee1);

	}
}

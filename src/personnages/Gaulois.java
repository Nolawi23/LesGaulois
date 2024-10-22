package personnages;


public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "» ");

	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de" + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesCopy = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesCopy != null && i < tropheesCopy.length; i++, nbTrophees++)
			this.trophees[nbTrophees] = tropheesCopy[i];
	}

//	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//	}

	public void boirePotion(int force) {
		effetPotion = force;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees>0) {
			parler("Je donne au musee tous mes trophees: ");
			for (int i = 0; i < nbTrophees; i++) {
				parler("- "+ trophees[i]);
				musee.donnerTrophees(this, trophees[i]);
			}
		}else {
			System.out.println("Le Gaulois " + this.getNom() + " n'a pas de trophees");
		}
		
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
		asterix.boirePotion(10);

	}

}

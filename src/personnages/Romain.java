package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] equipements = new Equipement[2];

	public Romain(String nom, int force) {
		assert isForcePositif(force);
		this.nom = nom;
		this.force = force;
	}

	private boolean isForcePositif(int force) {
		return force > 0;
	}

	private boolean isForceDiminue(int forceApresCoup) {
		return forceApresCoup < force;
	}

	public String getnom() {
		return nom;

	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "� ");
	}

	private String prendreParole() {
		return "Le romain" + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert isForcePositif(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		int forceApresCoup = force;
		assert isForceDiminue(forceApresCoup);
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1:
			if (equipements[0]== equipement)
				System.out.println("« Le soldat " + nom + " possède déjà un " + equipement + "!");
			else
				ajouterEquipement(equipement);
			break;
		case 2:
			System.out.println("« Le soldat " + nom + " est déjà bien protégé !»");
			break;
		}

	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[0] = equipement;
		nbEquipement++;
		System.out.println("« Le soldat " + nom + " s’équipe avec un " + equipement + ".");
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.parler("UN GAU... UN GAUGAU...");
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
	}
}

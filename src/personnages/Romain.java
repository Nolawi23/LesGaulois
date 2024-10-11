package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] equipements = new Equipement[2];

	public Romain(String nom, int force) {
		assert invariantForce(force);
		this.nom = nom;
		this.force = force;
	}

	private boolean invariantForce(int force) {
		return force > 0;
	}

	private boolean invariantForceDiminue(int copyforce) {
		return force < copyforce;
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
		assert invariantForce(force);
		int copyforce = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert invariantForceDiminue(copyforce);
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

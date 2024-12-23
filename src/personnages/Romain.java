package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private boolean vainqueur;
	private Equipement[] equipements = new Equipement[2];

	public Romain(String nom, int force) {
		assert isInvariantVerified();
		this.nom = nom;
		this.force = force;
	}

	public int getForce() {
		return force;
	}

	public String getNom() {
		return nom;
	}

	public boolean getVainqueur() {
		return vainqueur;
	}

	private boolean isInvariantVerified() {
		return this.force > 0;
	}

//	private boolean isForceCoupPositif(int forceCoup) {
//		return forceCoup > 0;
//	}
//
//	private boolean isForceDiminue(int forceApresCoup) {
//		return forceApresCoup < this.force;
//	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "» ");
	}

	private String prendreParole() {
		return "Le romain" + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert isForceCoupPositif(forceCoup);
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		int forceApresCoup = force;
//		assert isForceDiminue(forceApresCoup);
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		if (forceCoup == 0) {
			vainqueur = true;
			parler("Je suis victorieux");
			return equipementEjecte;
		} else
			vainqueur = false;
		force -= forceCoup;
		if (force > 0)
			parler("Aïe");
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		StringBuilder texte = new StringBuilder ("Ma force est de " + this.force + ", et la force du coup est de " + forceCoup);
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte.append("\nMais heureusement, grace àmon équipement sa force est diminué de ");
			for (int i = 0; i < nbEquipement && equipements[i] != null; i++) {
				if ((equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte.append(resistanceEquipement + "!");
		}
		parler(texte.toString());
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
			forceCoup = 0;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
			}
			
			equipements[i] = null;
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1:
			if (equipements[0] == equipement)
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + "!");
			else
				ajouterEquipement(equipement);
			break;
		default:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !»");
			break;
		}

	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s’équipe avec un " + equipement + ".");
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

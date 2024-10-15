package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
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
	
	private boolean isInvariantVerified() {
		return this.force > 0;
	}

	private boolean isForceCoupPositif(int forceCoup) {
		return forceCoup > 0;
	}

	private boolean isForceDiminue(int forceApresCoup) {
		return forceApresCoup < this.force;
	}

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
		force -= forceCoup;
		System.out.println(force);
		if (force==0)
			parler("Aïe");
		else{
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				}else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement(){ 
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup."); 
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) { 
			if (equipements[i] != null)  
				equipementEjecte[nbEquipementEjecte]= equipements[i];
			nbEquipementEjecte++; 
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

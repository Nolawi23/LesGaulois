package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert invariantForce(force);
		this.nom = nom;
		this.force = force;
		
	}
	private boolean invariantForce(int force) {
		return force>0;
	}
	
	public String getnom() {
		return nom;

	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "» ");
	}

	private String prendreParole() {
		return "Le romain" + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert invariantForce(force);
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
	}
	public static void main(String[] args) {
		Romain minus=new Romain("Minus", 6);
		minus.parler("UN GAU... UN GAUGAU...");


	}
}

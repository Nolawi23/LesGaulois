package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		villageois= new Gaulois[nbVillageoisMax];
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	} 

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return  villageois[numVillageois];	
	}
	
	public void afficherVillageois(Village village, Chef chef) {
		System.out.println("Dans " + village.getNom() + "du chef " + chef.getNom() + "vivent les legendaires gaulois: ");
		do {
			System.out.println(villageois[nbVillageois]);
			nbVillageois++;
			
		} while (nbVillageois<30);
		
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		/*
		 * Gaulois gaulois = village.trouverHabitant(30); Index out of range
		 */ 
		/*
		 * Chef abraracourcix = new Chef("Abraracourcix ",6, village);
		 * village.setChef(abraracourcix); Gaulois astérix = new Gaulois("Astérix", 8);
		 * village.ajouterHabitant(astérix); Gaulois gaulois =
		 * village.trouverHabitant(1); System.out.println(gaulois);
		 */
		Gaulois obelix= new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		System.out.println(village.trouverHabitant(0));
		village.afficherVillageois();
		
		
		
		
		
		
		
		
	}
	
}

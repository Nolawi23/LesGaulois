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
		System.out.println("Dans " + village.getNom() + " du chef " + chef.getNom() + " vivent les legendaires gaulois: ");
		do {
			System.out.println("-" + village.trouverHabitant(nbVillageois-1).getNom());
			nbVillageois--;
			
		}while (nbVillageois>0);
		
	}
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		
//		Gaulois gaulois = village.trouverHabitant(30); Index out of range
		Chef chef= new Chef("Abraracourcix", 6, village);
		village.setChef(chef);
		Gaulois asterix= new Gaulois("Astérix",25);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois); renvoie null

		Gaulois obelix= new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois(village, chef);
		
		
		
		
		
		
		
	}
	
}

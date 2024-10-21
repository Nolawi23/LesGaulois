package personnages;

public class Musee {
	Trophee[]trophees= new Trophee[200];
	int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee =  new Trophee(gaulois, equipement);
		trophees[nbTrophee]= trophee;
		nbTrophee++;
		
	}

}
 
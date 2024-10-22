package personnages;

public class Musee {
	Trophee[]trophees= new Trophee[200];
	int nbTrophee = 0;
	
	public String extraireInstructionsOCaml() {
		String texte = "let musee = [ "; 
		if (nbTrophee>0) {
			texte += "\n";
			for (int i = 0; i < nbTrophee; i++) {
				texte += trophees[i].donnerNom();
				Equipement equipement= trophees[i].getEquipement();
				texte += ", " + equipement.toString() + ";\n";
			}
		}
		texte += "]";
		return texte;
		
	}
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee =  new Trophee(gaulois, equipement);
		trophees[nbTrophee]= trophee;
		nbTrophee++;
	}

}
 
package personnages;

public class Musee {
	Trophee[]trophees= new Trophee[200];
	int nbTrophee = 0;
	
	public StringBuilder extraireInstructionsOCaml(){
		StringBuilder texte = new StringBuilder();
		texte.append("let musee = [ ");
		if (nbTrophee>0) {
			texte.append("\n");
			for (int i = 0; i < nbTrophee; i++) {
				texte.append(trophees[i].donnerNom());
				Equipement equipement= trophees[i].getEquipement();
				texte.append(", " + equipement.toString() + ";\n");
			}
		}
		texte.append("]");
		return texte;
		
	}
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee =  new Trophee(gaulois, equipement);
		trophees[nbTrophee]= trophee;
		nbTrophee++;
	}

}
 
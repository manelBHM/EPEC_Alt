package Stage;

import java.util.ArrayList;
import java.util.List;

public class Stagiaires {

	String nom;
	String prenom;
	String matricule;
	private static int nbStagiaire;
	
	public Stagiaires(String nom, String prenom, String matricule) {
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		nbStagiaire ++;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	
	public static int getNbStagiaire() {
		return nbStagiaire;
	}

	public static void setNbStagiaire(int nbStagiaire) {
		Stagiaires.nbStagiaire = nbStagiaire;
	}

	public List<Stagiaires> addStagiaire(Stagiaires s, ArrayList<Stagiaires> listStagiaire)
	{
		listStagiaire.add(s);
		
		return listStagiaire;
	}
	
	
	
}

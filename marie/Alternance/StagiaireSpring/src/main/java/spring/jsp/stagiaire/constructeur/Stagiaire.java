package spring.jsp.stagiaire.constructeur;
import java.util.*;

public class Stagiaire {

	private String nom,prenom,matricule;
	private static int nmbreStagiaire;
	
	
	public Stagiaire(String nom, String prenom, String matricule)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		nmbreStagiaire++;
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


	public static int getNmbreStagiaire() {
		return nmbreStagiaire;
	}


	public static void setNmbreStagiaire(int nmbreStagiaire) {
		Stagiaire.nmbreStagiaire = nmbreStagiaire;
	}
	
	
	public List<Stagiaire> addStagiaire(Stagiaire s, ArrayList<Stagiaire> listStagiaire)
	{
		listStagiaire.add(s);
		
		return listStagiaire;
	}
	
	
  
	
	
}

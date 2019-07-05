package App1;

public class Etudiant {

	private String nom;
	
	public Etudiant(String nom) {
	
	this.nom = nom; }	
		
	
	public String getNom() {
		return this.nom;

	}
	public void travailler() {
		System.out.println(this.nom + " se met au travail");
	}
	public void seReposer() {
		System.out.println(this.nom + " se repose");
	}
	
	}
		
	



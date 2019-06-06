package Aeroport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pilote {

	int id;
	String nom;
	String site;
	
	HashMap<Pilote, Integer> listePilote = new HashMap<Pilote, Integer>();
	
	public Pilote(int id, String nom, String site) {
		super();
		this.id = id;
		this.nom = nom;
		this.site = site;
		
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	@Override
	public String toString() {
		return "Pilote [id=" + id + ", nom=" + nom + ", site=" + site + "]";
	}
	public static StringBuilder afficherListe(int listeVol) {
		// TODO Auto-generated method stub
		return null;
	}
	public static StringBuilder afficherListe(ArrayList<Vol> listeVol) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

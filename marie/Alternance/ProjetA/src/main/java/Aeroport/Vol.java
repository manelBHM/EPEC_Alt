package Aeroport;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Vol {

	int id;
	int pilote;
	int avion;
	String heureArrivee;
	String heureDepart;
	String siteArrivee;
	String siteDepart;
	StringBuilder str = new StringBuilder();
	StringBuilder s = new StringBuilder();
	
	HashMap<Vol, Integer> listeVol = new HashMap<Vol, Integer>();
	
	public Vol(int id, int pilote, int avion, String heureArrivee, String heureDepart, String siteArrivee,
			String siteDepart) {
		super();
		this.id = id;
		this.pilote = pilote;
		this.avion = avion;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.siteArrivee = siteArrivee;
		this.siteDepart = siteDepart;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPilote() {
		return pilote;
	}
	
	public void setPilote(int pilote) {
		this.pilote = pilote;
	}
	
	public int getAvion() {
		return avion;
	}
	
	public void setAvion(int avion) {
		this.avion = avion;
	}
	
	public String getHeureArrivee() {
		return heureArrivee;
	}
	
	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	
	public String getHeureDepart() {
		return heureDepart;
	}
	
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	
	public String getSiteArrivee() {
		return siteArrivee;
	}
	
	public void setSiteArrivee(String siteArrivee) {
		this.siteArrivee = siteArrivee;
	}
	
	public String getSiteDepart() {
		return siteDepart;
	}
	
	public void setSiteDepart(String siteDepart) {
		this.siteDepart = siteDepart;
	}
	
	@Override
	public String toString() {
		return "Vol [id=" + id + ", pilote=" + pilote + ", avion=" + avion + ", heureArrivee=" + heureArrivee
				+ ", heureDepart=" + heureDepart + ", siteArrivee=" + siteArrivee + ", siteDepart=" + siteDepart + "]";
	}
	
	public StringBuilder ListeV(Map<Vol, Integer>ListeVol) {
		
		for(Entry<Vol, Integer> element : this.listeVol.entrySet()) {
		s.append("- ").append(element.getKey().getId()).append(" - ").append(element.getKey()).append("<br>");
		}
		return s;
	}
	
	public StringBuilder afficherListe(Map<Vol, Integer> vol) {
		str.append("------------------- VOL -------------------").append("<br><br>");
		str.append(ListeV(vol));
		
		
		return str;
	}

	public void addVol(Vol ele, int i) {
		// TODO Auto-generated method stub
		
	}

	public Map<Vol, Integer> getVol() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

package Model;

public class Vol {
	
	String id ;
	String avion, heureArrivee, heureDepart, pilote, siteArrivee, siteDepart;
	
	
	
	
	public Vol() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Vol(String id, String avion, String heureArrivee, String heureDepart, String pilote, String siteArrivee,
			String siteDepart) {
		super();
		this.id = id;
		this.avion = avion;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.pilote = pilote;
		this.siteArrivee = siteArrivee;
		this.siteDepart = siteDepart;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAvion() {
		return avion;
	}
	public void setAvion(String avion) {
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
	public String getPilote() {
		return pilote;
	}
	public void setPilote(String pilote) {
		this.pilote = pilote;
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
	

}

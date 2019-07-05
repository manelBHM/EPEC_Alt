package Model;

public class Facture {
	String libelle;
	int Qts, Prix;
	public Facture(String libelle, int qts, int prix) {
		super();
		this.libelle = libelle;
		Qts = qts;
		Prix = prix;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getQts() {
		return Qts;
	}
	public void setQts(int qts) {
		Qts = qts;
	}
	public int getPrix() {
		return Prix;
	}
	public void setPrix(int prix) {
		Prix = prix;
	}
	
	
	

}

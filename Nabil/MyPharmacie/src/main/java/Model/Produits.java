package Model;

public class Produits {
	
	public String libelle;
	public int Prix;
	public int Qts;

	public Produits(String libelle, int Prix, int Qts) {
		super();
		this.libelle = libelle;
		this.Prix = Prix;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getPrix() {
		return Prix;
	}

	public void setPrix(int prix) {
		Prix = prix;
	}

	public int getQts() {
		return Qts;
	}

	public void setQts(int qts) {
		Qts = qts;
	}

	
	
	
	
	
}

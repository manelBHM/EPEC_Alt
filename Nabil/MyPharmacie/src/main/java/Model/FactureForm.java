package Model;

public class FactureForm {
	
	String libelle;
	double Prix, total;
	int Qts;
	
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return Prix;
	}
	public void setPrix(double prix) {
		Prix = prix;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQts() {
		return Qts;
	}
	public void setQts(int qts) {
		Qts = qts;
	}

	
	
	
}

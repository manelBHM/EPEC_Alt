package cpro.alternant;

public class Alternant {

	private String nom, prenom, naissance, entreprise, img;
	
	public Alternant(String nom, String prenom, String naissance, String entreprise, String img)
	{
		this.nom = nom;
		
		this.prenom = prenom;
		
		this.naissance = naissance;
		
		this.entreprise = entreprise;
		
		this.img = img;
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

	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nom: "+this.nom+"<br>"+"prenom: "+this.prenom+"<br>"+"naissance: "+this.naissance+"<br>"+"entreprise: "+this.entreprise+"<br>"+"img: "+this.img;
	}
	
	
	
	
}
package exemple7;

public class Ville {
	
	public String nomVille ;
	public int nbreH = -1;
	
	public Ville () {}
	
	// cons 1 prend q nom vill
	
	
	public Ville (String nomVille) {
		this.nomVille= nomVille;
	}
	
	// cons prend les 2 

	public Ville (String nomVille, int nbreH) {
		this.nomVille= nomVille;
		this.nbreH = nbreH;
	}
	
	
	public String presenteToi () {
		
		String message;
		
		if (nbreH >0 )
		{message ="La ville est "+nomVille+". Son nombre d'habitants est de "+nbreH+" .";
		return message; }
		else
			message ="La ville est "+nomVille+". Son nombre d'habitants est inconnu.";	
		
		
		return message;
	}
	
}

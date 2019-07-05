package exemple7;

public class Capitale extends Ville {
	
	public String nomCapitale;
	public String nomPays;
	
	public Capitale (String nomCapital, String nomPays) {
		super();
		
		this.nomCapitale= nomCapital;
		this.nomPays= nomPays;
	}
	
	public Capitale (String nomCapital,int nbreH, String nomPays) {
		super();
		
		this.nomCapitale= nomCapital;
		this.nbreH=nbreH;
		this.nomPays = nomPays;

}
	
	
public String presenteToi () {
		
		String message;
		
		if (nbreH >0 )
		{message ="La ville est "+nomCapitale+". le nombre d'habitants est de "+nbreH + ". C'est la capitale de "+nomPays;
		return message; }
		else
			message ="La ville est "+nomCapitale+". C'est la capitale de "+nomPays+". Le nombre d'habitants est inconnu ";	
		
		
		return message;
	}
}

package my.TestUnitaire;

public class Calculator {

	
	public int carre(int n)
	{
		int resultat;
		
		resultat = (int) Math.pow(n, n);
		
		return resultat;
	}
	
	
	
	public int cube(int n)
	{
		int resultat;
		resultat = (int) n*n*n;
		return resultat;
}
	
}
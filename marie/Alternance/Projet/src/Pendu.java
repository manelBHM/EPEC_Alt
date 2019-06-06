import java.util.Scanner;
import java.util.Random;
public class Pendu {

	public static String[] main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String[] tabMots = {"simplon","ordinateur","console","electronique","bienvenue","programmation","develloppeur","algorythme"}; 
		int i = new Random().nextInt(tabMots.length);
		int nbCoups=10;
		int nbErreur=0;
		String motADeviner;
		String[] motTrouver;
		String lettre;
		motTrouver = new String[motADeviner.length()];
		int i=0;		
		System.out.println("*********************************");
		System.out.println("*Bienvenue dans le jeu du pendu!*");
		System.out.println("*********************************");
		System.out.print("Voici le mot a trouver: ");
		
		System.out.println("Entrez une lettre");
		
	for (i=0;i<motADeviner;i++){
		
	if (lettre == motADeviner.charAt(i)){
			motTrouver[i]=lettre;
}
	else{
		nbErreur ++; nbCoups --;
}
		if(motTrouver=motADeviner)
			System.out.println("Vous avez trouvez le mot feliciations!");
		else {
			System.out.println("Fin de partie vous avez perdu!");
			System.out.println("Le mot etait: "+motADeviner);
		}
}
	}
	private static String random() {
		// TODO Auto-generated method stub
		return 0;
	}
}



		

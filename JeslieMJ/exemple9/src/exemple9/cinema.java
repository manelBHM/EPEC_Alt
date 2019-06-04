package exemple9;
import java.util.Scanner;



public class cinema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Bonjour et bienvenu(e) au cinéma de Montreuil !");}
	    Scanner sc = new Scanner(System.in);
	
	    
	    
	    int age;

		 
		  
		 public void age() {
		      
			   System.out.println("1 = - de 3 ans");
		        System.out.println("2 = - de 60 ans");
		        System.out.println("3 = + de 60 ans");}      
		 
		 
		 
		 
		 
		 public void ville() {
			 System.out.println("O = vous habitez à Montreuil");
		 System.out.println("N = vous n'habitez pas à Montreuil");}
		 
		 
		 
		 public void prix() {
			 System.out.println("Votre ticket est gratuit");
			 		System.out.println("Votre ticket est à 4 euros");
			 		System.out.println("Votre ticket est à 5 euros");
			 		System.out.println("Votre ticket est à 8 euros"); }
		 
		 
		 public int askAge() {
		        age();
		        int age = sc.nextInt();
		        return age;}
		 
		 
		 public int askVille() {
			 ville();
			 int ville=sc.nextInt();
			 return ville;}
		 
		 
		 
		 public int ticket() {
			 prix();
			 int prix = 0;
			 return prix;}
		 
		 
		 
		 
		 
		 }

	

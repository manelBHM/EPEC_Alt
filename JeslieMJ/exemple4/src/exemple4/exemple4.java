/* Exercices sur les mentions */


package exemple4;

import java.util.Scanner;

public class exemple4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner clavier = new Scanner(System.in);
		
		int note;
		System.out.println("entrez votre note");
		
		  note = clavier.nextInt();
		switch(note) {
		
		case 1: case 2: case 3: case 4: case 5: case 6: case 7 : case 8 : case 9:
		
		
		System.out.println("IL FAUT TRAVAILLER!");
		 
		break;
		
		case 10 : case 11 :
		System.out.println("Passable.");
		
		break;
		
		case 12 : case 13 :
		
		System.out.println("Assez bien !");
		
		
		break;
		
		case 14 : case 15 : 
			
		
	System.out.println("Bien !");
	
	break;
	
		case 16 : case 17 : case 18 : case 19 : case 20 :
		
				System.out.println("Très bien !!!");
		break;
		
		default:
		System.out.println("veuillez retaper votre note");
		
		
		
		}
		
		
		/*int x = 10, y= 20;
		int max = (x < y)? (y<10)? y%10: y*2 :x;
		System.out.println(max);*/
				}

}

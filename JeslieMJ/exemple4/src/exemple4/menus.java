
package exemple4;

import java.util.Scanner;

public class menus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String poulet = new String ("poulet");
		String boeuf = new String ("boeuf");
		String végétarien = new String ("végétarien");
		System.out.println("Choisissez si vous voulez un menu au poulet, un menu au boeuf,ou un menu végétarien !");
		Scanner clavier= new Scanner(System.in);
		String menu = clavier.nextLine();
		
		
		
		if(menu.contains(poulet)) {
			System.out.println("vous avez choisi un menu au poulet, bon appétit !!");
		}
		 else if (menu.contains(boeuf)) {
			 
			 System.out.println("vous avez choisi un menu au boeuf, bon appétit !!");
		}
		
		 else if (menu.contains(végétarien)) {
			 
			 System.out.println("vous avez choisi un menu végétarien, bon appétit !!");
		 }
		 else 
			 System.out.println("Pouvez-vous refaire votre choix s'il vous plaît ? ");
		
		
	/*	switch(a) {
		
		case 1:
			System.out.println("vous avez choisi un menu au poulet, bon appétit !!");
			
			break;
		case 2:
			System.out.println("vous avez choisi un menu au boeuf, bon appétit !!");
	break;
	
		case 3:
			System.out.println("vous avez choisi un menu végétarien, bon appétit !!");
			break;
			
		default:
			
			System.out.println("Pouvez-vous refaire votre choix s'il vous plaît ? ");
			
			*/
		}
		
		
		
		
	}



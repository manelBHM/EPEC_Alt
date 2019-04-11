package Game;

import java.util.Scanner;



public class FizzBuzz {  
//	TimerTask task = new TimerTask();
	
	public void LaunchGame() throws InterruptedException {
		
//		Timer timer = new Timer();
//		timer.schedule( task, 5*1000 );
		int nbr = 20;
		Scanner sc = new Scanner(System.in);
	
		
		System.out.println("BONJOUR BIENVENUE DANS FIZZBUZZ ");
		System.out.println("VOUS AVEZ 5 SECONDE POUR REPONDRE");
		System.out.println("'A' = FIZZ , 'Z' = BUZZ , 'E' = FIZZBUZZ ");
		System.out.println("PRESS Y TO LAUNCH THE GAME !");
		char go = sc.nextLine().toUpperCase().charAt(0);
		
		if (go == 'Y') 
		{
		
		for (int i = 1; i <= nbr; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				
				Thread.sleep(500);
				System.out.println("LE NOMBRE : " + i );
				System.out.println("FIZZ, BUZZ or FIZZBUZZ !?");
				int limit = 5000;
			    double startTime = System.currentTimeMillis();
			    char reponse = sc.nextLine().toUpperCase().charAt(0);
			    double endTime = System.currentTimeMillis();
			    double T = (endTime - startTime);
			    double AfficheTime = (T / 1000); 
			    
			    if ((startTime + limit) < System.currentTimeMillis()) {
			        System.out.println("TIME IS UP! YOU LOOSE !");
			        System.out.println("Time taken : " + AfficheTime + "s");
			        System.out.println("Votre Score ! : " + i);
			        System.exit(0);
			    }
			    
			    else if (reponse == 'A' || reponse == 'Z') {
			    	System.out.println("YOU LOOSE ! MAUVAISE REPONSE !");
			    	System.out.println("Votre Score ! : " + i);
			    	System.exit(0);
			    }
			    else
			        System.out.println("FIZZBUZZ BRAVO !!");
			    	System.out.println("Time taken : " + AfficheTime + "s");
			    
//					for (int timer1 = 0; timer1 <= 5; timer1++){
//						Thread.sleep(1000);
//						System.out.println("TIME : " + timer1);
						//String reponse = sc.nextLine();
				
//				}
//				System.out.println("FIZZBUZZ BRAVO !!");	
			}
			else if(i % 5 == 0) {
				
				Thread.sleep(500);
				System.out.println("LE NOMBRE : " + i );
				System.out.println("FIZZ, BUZZ or FIZZBUZZ !?");
				
				int limit = 5000;
			    double startTime = System.currentTimeMillis();
			    char reponse = sc.nextLine().toUpperCase().charAt(0);
			    double endTime = System.currentTimeMillis();
			    double T = (endTime - startTime);
			    double AfficheTime = (T / 1000); 
			    
			    if ((startTime + limit) < System.currentTimeMillis()) {
			        System.out.println("TIME IS UP! YOU LOOSE !");
			        System.out.println("Time taken : " + AfficheTime + "s");
			        System.out.println("Votre Score ! : " + i);
			    System.exit(0);
			    }
			    
			    else if (reponse == 1 || reponse == 3) {
			    	System.out.println("YOU LOOSE ! MAUVAISE REPONSE !");
			    	System.out.println("Votre Score ! : " + i);
			    	System.exit(0);
			    }
			    else
			        System.out.println("BUZZ BRAVO !!");
			    	System.out.println("Time taken : " + AfficheTime + "s");
			    	;
			   
//				for (int timer1 = 0; timer1 <= 5; timer1++) {
//					
//					System.out.println("TIME : " + timer1);
//					Thread.sleep(1000);
					//String reponse = sc.nextLine();
//				}
//				System.out.println("BUZZ BRAVO !!");
			}
			
			else if(i % 3 == 0) {
				
				
				Thread.sleep(500);
				System.out.println("LE NOMBRE : " + i );
				System.out.println("FIZZ, BUZZ or FIZZBUZZ !?");
			    
				int limit = 5000;
			    double startTime = System.currentTimeMillis();
			    char reponse = sc.nextLine().toUpperCase().charAt(0);
			    double endTime = System.currentTimeMillis();
			    double T = (endTime - startTime);
			    double AfficheTime = (T / 1000);
			    if ((startTime + limit) < System.currentTimeMillis()) {
			        System.out.println("TIME IS UP! YOU LOOSE !");
			        System.out.println("Time taken : " + AfficheTime + "s");
			        System.out.println("Votre Score ! : " + i);
			    System.exit(0);
			    }
			    
			    else if (reponse == 2 || reponse == 3) {
			    	System.out.println("YOU LOOSE ! MAUVAISE REPONSE !");
			    	System.out.println("Votre Score ! : " + i);
			    	System.exit(0);
			    }
			    else
			        System.out.println("FIZZ BRAVO !!");
			    	System.out.println("Time taken : " + AfficheTime + "s");
//				for (int timer1 = 0; timer1 <= 5; timer1++) {
//					System.out.println("TIME : " + timer1);
//					Thread.sleep(1000);
//					//String reponse = sc.nextLine();
//				}
					
//			System.out.println("FIZZ BRAVO !!");
					
			}
			else
				Thread.sleep(500);
				System.out.println(i);
			}
			
		}
		else
			System.out.println("RELAUNCH THE APP !");
		
	}
}


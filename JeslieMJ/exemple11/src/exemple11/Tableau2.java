package exemple11;

import java.util.Scanner;

public class Tableau2 {

private static Scanner clavier;

public static void main(String[] args) {
		
		
		// Matrices a creer 

		clavier = new Scanner(System.in);

		  System.out.println(" Donnez la dimension de la matrice :");
 
		    int tailleMatrice = clavier.nextInt();

		        int [][] mat = new int [tailleMatrice][tailleMatrice]   ;

		

		            for ( int i = 0 ; i <tailleMatrice ; i++  )
 
		              {   for (int j = 0 ; j<tailleMatrice ; j++ ) {

		                     System.out.println(" Entrez un nombre entier pour la rangee "  + i + "  et la colonne "  +  j + ": "  ); 

		                          mat[i][j]= clavier.nextInt();

		}

		}
		// affichage matrice initiale 

		System.out.println(" La matrice originale : ");

		   for ( int i = 0 ; i <tailleMatrice ; i++  )

		   {   for ( int j = 0 ; j < mat[i].length ; j++  ) {

		     	System.out.print("    "  + mat[i][j]);

		}

		               System.out.println();System.out.println();

		}

		

		// affichage matrice transposse 

		

		System.out.println(" La matrice transposee  : ");

		  for ( int i = 0 ; i <tailleMatrice ; i++  )

		   {   for ( int j = 0 ; j < mat[i].length ; j++  ) {

			

			    System.out.print("    " + mat[j][i]);

			}

		   System.out.println();
		   System.out.println();

		}



	}



}


                                

                                  



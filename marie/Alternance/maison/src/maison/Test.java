package maison;

public class Test {

	public static void dessinRectangle (int pX, int pY, int longeur, int largeur) {   
		char      tabRectangle[][] = new char[50][50];
    	for (int x = 0; x < longeur; x++) {
         tabRectangle[x + (pX - 1)][0 + (pY - 1)] = '|';
    }       
    	for (int y = 0; y < largeur; y++) {
        tabRectangle[0 + (pX - 1)][y + (pY - 1)] = 'O';
    }        
    	for (int x1 = 0; x1 < longeur; x1++) {            
    		tabRectangle[x1 + (pX - 1)][largeur - 1 + (pY - 1)] = 'O';
    }        
    	for (int y1 = 0; y1 < largeur; y1++) {
        tabRectangle[longeur - 1 + (pX - 1)][y1 + (pY - 1)] = 'O';
    }
	}	
			  
			public static void main (String[] args) {
				
				char      tabRectangle[][] = new char[50][50]; 
	 
	    for (int x = 0; x < tabRectangle.length; x++) {           
	    	for (int y = 0; y < tabRectangle[x].length; y++) {      
	    		tabRectangle[x][y] = '.';
	        }
	    }
      
	    dessinRectangle(17, 17, 14, 14);       
	    dessinRectangle(13, 26, 4, 4);
	    dessinRectangle(22, 19, 3, 3);
	    dessinRectangle(22, 26, 3, 3);
	    dessinRectangle(24, 22, 6, 4);        dessinRectangle(13, 39, 18, 3);
	    dessinRectangle(3, 34, 12, 12);
	    dessinRectangle(1, 1, 9, 9);
	    dessinRectangle(10, 1, 3, 1);        // dessinRectangle(7,8);       
	    for (int x = 0; x < tabRectangle.length; x++) {
	    	// afficher le tableau            
	    	for (int y = 0; y < tabRectangle[x].length; y++) {    
	    		System.out.print(tabRectangle[x][y] + " ");
	    	}
	    }
	        
	        System.out.println("");
	    }   
			}




public class Misson {
	
	 int droite;
	    int bas;
	    int haut;
	    
	    static char tab [][] = new char [16][16];
	    

	public static void main(String[] args) {
      
		remplir();

	}
	
	
	public static void Element1(int L, int C, int droite, int bas) {
		
		for (int i=C; i<=C+droite; i++) {
			tab[L][i]='*';
			tab[L+bas][i]='*';
		}
		for(int i = L; i<=L+bas;i++) {
			tab[i][C]='*';
			tab[i][C+droite]='*';
			 
		}
	}

	 public static void element2(int L, int C, int droite, int bas) {

	        for (int i = C; i <= C + droite; i++) {

	            tab[L][i] = '*';
	            tab[L + bas][i] = ' ';

	        }

	        for (int i = L; i <= L + bas; i++) {

	            tab[i][C] = '*';
	            tab[i][C + droite] = '*';

	        }

	    }

	private static void remplir() {
		for (int i=0; i<tab.length; i++) {
			for(int j=0; j<tab.length; j++) {
				tab[i][j]=' ';
				Element1(3, 0, 15, 12);
				 // PORTE
                element2(5, 5, 4, 10);
                Element1(8, 1, 3, 3);
                Element1(8, 11, 3, 3);
                // CHEMINEE
                element2(0, 11, 4, 3);
				 System.out.print(tab[i][j] + "   ");
			}
			System.out.println("\n");
		}
		
	}
	
	

}

public class Maison {

	int droite;
	int bas;
	int haut;

	static char tab[][] = new char[16][16];

	public static void main(String[] args) {

		remplir();

	}


	public static void element(int l, int c, int droite, int bas) {

		for (int i = c; i <= c + droite; i++) {

			tab[l][i] = '*';
			tab[l + bas][i] = '*';

		}

		for (int i = l; i <= l + bas; i++) {

			tab[i][c] = '*';
			tab[i][c + droite] = '*';

		}

	}

	//Définit la porte et la cheminée
	
	public static void element2(int l, int c, int droite, int bas) {

		for (int i = c; i <= c + droite; i++) {

			tab[l][i] = '*';
			tab[l + bas][i] = ' ';

		}

		for (int i = l; i <= l + bas; i++) {

			tab[i][c] = '*';
			tab[i][c + droite] = '*';

		}

	}
	public static void remplir() {

		for (int i = 0; i < tab.length; i++) {

			for (int j = 0; j < tab.length; j++) {

				tab[i][j] = ' ';

				element(3, 0, 15, 12);
				// PORTE
				element2(5, 5, 4, 10);
				// CHEMINEE
				element2(0, 11, 4, 3);
				element(8, 1, 3, 3);
				element(8, 11, 3, 3);
			    

				System.out.print(tab[i][j] + "   ");

			}
			System.out.println("\n");

		}

	}


}

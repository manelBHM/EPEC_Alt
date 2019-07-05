package checksitupeuxacheter;

public class CheckSiTuPeuxAcheter {

	public static boolean checkSiTuPeuxAcheter(int prix) {

		// tu as 22 euros en monnaies de 2 euros, la machine ne rend pas de monnaie, check si tu peux payer


		boolean res = false;

		if(prix%2 == 0)

		{
			res = true;
			System.out.println("Validé");
		}

		else
		{
			res = false;
			System.out.println("La Machine rend pas de la monnaie");
		}

		return res;

	}

}

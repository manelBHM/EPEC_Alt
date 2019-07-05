package gameF;

public class GameFizz {
	
	public static String Game(int i )throws  IllegalArgumentException {
		 if(i<=0) 
		{
			throw new IllegalArgumentException();
		}
	
		 else	if (i%3==0 && i%5==0) {
				return "fizzBuzz";
			}
			else if(i%3==0) {
				return "fizz";
			}
			else if (i%5==0) {
				return  "buzz";
			}
			
			else {
				return String.valueOf(i) ; 
			}

}
	public static void metGame() {
		
		for ( int i=1; i<100; i++) {
			System.out.println(GameFizz.Game(i));
		}
	}
	
	public static void main(String[] args) {
		
metGame();

	}

}

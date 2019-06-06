package app;

import java.util.ArrayList;

public class Part1 {

	 public static boolean checkIfPair(int number) {
	       int reste = number % 2;
	       if (reste == 0) {
	           return true;
	       }else {
	           return false;
	       }    }
	    
	    public static boolean checkIfPairPairImpair(int number1, int number2, int number3) {
	        int reste1 = number1 % 2;
	        int reste2 = number2 % 2;
	        int reste3 = number3 % 2;
	        if (reste1==0 && reste2==0 && reste3!=0) {
	            return true;
	        }else {
	        return false;
	    }
	    
	    }
	    public static boolean checkIfSumIsPair(int number1, int number2, int number3) {
	        
	        int resultat = number1 + number2 + number3;
	        int reste = resultat % 2;
	        if(reste == 0) {
	            return true;
	        }else {
	        return false;
	        }
	    }
	    
	    public static boolean checkIfAllElementsPair(int[] array) {
	        for(int i =0; i<array.length; i++) {
	            int reste = array[i] % 2;
	            if(reste==0) {
	                return true;
	            }else {
	            }
	        }
	        return false;
	    }
	    
	    public static ArrayList<Integer> exportAllElementsPair(int[] array) {
	        ArrayList<Integer>  a1 = new ArrayList<Integer>();
	        for(int i =0; i<array.length; i++) {
	            if (array[i] % 2==0) {
	                a1.add(array[i]);
	        }
	    }
	            
	        return a1;
	    }
	    public static ArrayList<Integer> exportAllUniqueElementsPair(int[] array) {
	        ArrayList<Integer> a1 = new ArrayList<Integer>();
	        for(int i =0;i<array.length; i++) {
	            
	            if(array[i] % 2==0 && !a1.contains(array[i])) {
	                a1.add(array[i]);
	                
	            }
	        }
	        return null;
	    }
	    
	    
	    public static boolean checkSiTuPeuxAcheter(int prix) {
	        // tu as 22 euros en monnaies de 2 euros, la machine ne rend pas de monnaie, check si tu peux payer
	        
	        if(prix<=22 &&(prix %2)==0 ) {
	            return true;
	        }
	        else {
	        return false;
	    }
	    }
}

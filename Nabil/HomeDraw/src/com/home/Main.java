package com.home;


public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int[][] matrix = new int[10][20];
        int x,y;
        
        	x = 20;
        	y = 80;
        	
        	afficher(10,10);
        	afficher(20,80);

	}
	
	
	public static void  afficher( int x , int y) {
		
		 for(int i =0;i<x;i++){

             for(int j =0;j<y;j++)
             {
                 if (i == 0 || i == x-1 || j == 0 || j == y-1)
                 {
                     System.out.print("*");
                 }
                 else
                 {
                     System.out.print(" ");
                 }
             }
         System.out.print("\n");
         }
		

	}
	public static void afficher2( int x , int y) {
		
		 for(int i =0;i<x;i++){

            for(int j =0;j<y;j++)
            {
                if (i == 10 || i == x-1 || j == 10 || j == y-1)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
        System.out.print("\n");
        }
		
		
	}

}

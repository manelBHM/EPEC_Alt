package com.issamdrmas;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Ma Maison \n");
		
		int r = 38;
		int x = 8;
		String j = "°";
		String y, n;
		
		String c = "°";
		String h, v;
		
		y =  new String(new char[x ]).replace("\0", j);
		n = j + new String(new char[x-2]).replace("\0", " ") + j;
		
		System.out.println("                              "+y);
		for(int p=x-5; p>=1; --p) {
			System.out.println("                              "+n);
		}
		
		h =     new String(new char[r  ]).replace("\0",  c);
		v = c + new String(new char[r-2]).replace("\0", " ") + c;
	   
		 System.out.println(h);	
		for (int i=r-28; i>=1; --i) {
		    System.out.println(v);
		    if(i == 1) {
		    	System.out.println("°    °°°°°°°°         °°°°°°°°       °");
				for(int p=x-2; p>=1; --p) {
					System.out.println("°    "+n+"         "+n+"       °");
				}
		    }
		   
		}
	
		System.out.println(h+"°°°");
		System.out.println(h+"°°°°°");
		System.out.println(h+"°°°°°°°°");
		
		
				 
    }}
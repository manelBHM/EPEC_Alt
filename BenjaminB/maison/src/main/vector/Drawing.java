package main.vector;

import java.util.Scanner;

public class Drawing {
	public Drawing() {
		char [][] drawing = {
	        { '_', '_', '_', '_','_','_' } , // tableau [0] de int
	        { '|', '|', '|', '|', '|', '|', '|' } // tableau [1] de int
	    };
		int i, j;
		for(i=0; i<drawing.length; i++) {
			for(j=0; j<drawing[i].length; j++) {
				//Action sur matrice[i][j]
			}
		}
/*	Scanner scH = new Scanner(System.in);
    System.out.println(" Donnez la largeur de la maison : ");
	Scanner scV = new Scanner(System.in);
    System.out.println(" Donnez la hauteur de la maison : ");
	// TODO Auto-generated method stub
	Horizontal horizontal = new Horizontal(scH);
	Vertical vertical = new Vertical(scV);*/
	}
}

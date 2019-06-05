package main.vector;

import java.util.Scanner;


public class Vertical {
    public Vertical(Scanner scV) {

	int y2= scV.nextInt();
	for(int y1=0; y2>y1; y1++ ) {
		System.out.println("|");
	}
    }
}

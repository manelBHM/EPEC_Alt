package exex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Run{
	

	public static void main(String[] args) {
		Stagiaire p1 = new Stagiaire(225, "Jean.L", 25);
		Stagiaire p2 = new Stagiaire(100,"Franck.D",27);
		Stagiaire p3 = new Stagiaire(220,"Alain.J", 20);
		Stagiaire p4 = new Stagiaire(220,"Victor.T", 20);
		
		
		List<Stagiaire> liste= new ArrayList<Stagiaire> ();
		liste.add(p1);
		liste.add(p2);
		liste.add(p3);
		liste.add(p4);
		 
		System.out.println("----------Liste originale----------");
		System.out.println(liste);
		System.out.println("\n");
		
		System.out.println("----------Liste triée par id----------");
	
		Comparator<Stagiaire>  idComp = Stagiaire.idComp;
		Collections.sort(liste , idComp );
		System.out.println(liste);
		System.out.println("\n");
		
		System.out.println("----------Liste triée par âge----------");
		Comparator<Stagiaire>  idCompAge = Stagiaire.idCompAge;
		Collections.sort(liste , idCompAge );
		System.out.println(liste);
		
		
		
	}


}
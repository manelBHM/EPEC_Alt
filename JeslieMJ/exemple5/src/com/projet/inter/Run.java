package com.projet.inter;

import java.util.Date;

public class Run {

	
		

		public static void main(String[] args) {
			// TODO Auto-generated method stub
            
			profil DIR = new profil(1,"DIR") ;
			profil EMP = new profil(2,"EMP");
			
			
			Personne personne1 = new Personne("Jean De La Fontaine",new Date ("11/09/1234"), 1900,DIR);
			personne1.affiche();
			
			Personne personne2 = new Personne("Vincent Van Gogh",new Date ("17/02/1810"),1988,EMP);
			personne2.affiche();
			
			Personne personne3 = new Personne("Aristote", new Date("08/06/0100"), 2100,EMP);
			personne3.affiche();
		}


	}



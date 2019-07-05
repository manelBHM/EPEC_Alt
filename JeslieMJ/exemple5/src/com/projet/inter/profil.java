package com.projet.inter;

public class profil {


	private int code;
	private String libelle;
	
	
	public profil(int code, String libelle) {
		
		
		this.code = code;
		this.libelle=libelle;}
		
		public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

		public void affiche () {
			
			System.out.println("Mon code est le "+code+" . Je suis un "+ libelle);
		}
		
	}



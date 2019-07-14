package com.simplon.DVD.facture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.simplon.DVD.entity.Client;
import com.simplon.DVD.produit.Produit;

public class Facture {
	Map<Produit, Integer> panier = new HashMap<Produit, Integer>();
	Client client;
	double total;
	StringBuilder str1 = new StringBuilder();
	StringBuilder str2 = new StringBuilder();
	
	public Facture(Client client) {
		this.client = client;
	}

	public Map<Produit, Integer> getPanier() {
		return panier;
	}

	public void setPanier(Map<Produit, Integer> panier) {
		this.panier = panier;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public void addProduit(Produit produit, Integer quantite) {
		this.panier.put(produit, quantite);
	}
	
	public double totalProduits(Map<Produit, Integer> panier) {
		for(Entry<Produit, Integer> element : this.panier.entrySet()) {
			total += (element.getKey().getPrix()) * element.getValue();
		}
		return total;
	}
	
	public String resumePanier(Map<Produit, Integer> panier) {
		System.out.println("Résumé de votre panier : ");
		for(Entry<Produit, Integer> element : this.panier.entrySet()) {
			System.out.println("- " + element.getValue() + " " + element.getKey().getNom() + " / " + element.getKey().getPrix() + " Euros unite");
			
		}
		return "Le total de la commande est de " + totalProduits(panier) + " Euros";
	}
	
	public StringBuilder xPanier(Map<Produit, Integer>panier) {
		for(Entry<Produit, Integer> element : this.panier.entrySet()) {
			str2.append("- ").append(element.getValue()).append(" ").append(element.getKey().getNom()).append(" - ").append(element.getKey().getPrix()).append(" Euros unite ").append("<br>");
			}
			return str2;
	}
	
	public Map<Produit, Integer> getProduits() {
		return panier;
	}
	
	public StringBuilder afficherFacture(Map<Produit, Integer> produits) {
		str1.append("------------------- FACTURE --------------------").append("<br> <br>");
		str1.append(client.getPrenom()).append("<br>");
		str1.append(client.getNom()).append("<br><br>");
		str1.append("------------------- PRODUITS -------------------").append("<br><br>");
		str1.append(xPanier(produits));
		str1.append("<br>------------------------------------------------").append("<br><br>");
		str1.append("TOTAL : ").append(totalProduits(produits)).append(" euros").append("<br>");
		
		return str1;
	}
	
	
	
	
	
	
}	



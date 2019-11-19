package com.Ecommerce.service;

import com.Ecommerce.entities.Adresse;
import com.Ecommerce.entities.Commande;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICommande {

    public Commande passerCommande(String username);
    public double getTotal(Commande commande);
    public List<Commande> getAllCommandesClient(String username);
    public Page<Commande> getHistoryCommandes();
    public Commande payerCommande(Long idCommande, String username, Adresse adresse);
}

package com.Ecommerce.service;

import com.Ecommerce.dao.AdresseRepository;
import com.Ecommerce.dao.CommandeRepository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommandeImpl implements ICommande {

    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private PanierService panierService;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdresseRepository adresseRepository;
     @Autowired
     private MouvStockService mouvStockService;


    @Override
    public Commande passerCommande(String username){
        // Map<Long, LigneCommande> items = panierService.getAllArticlesPanier(username);
        AppUser u = userRepository.findByUsername(username);
        Panier p = panierRepository.findByUserId(u.getId());
        Map<Long, LigneCommande> items =p.getItems();
        Commande cmd=new Commande();
        cmd.setUser(u);
        cmd.setETAT("EN_COURS");
        //cmd.setDateCommande(LocalDateTime.now());
        cmd.getItems().putAll(items);
       cmd = commandeRepository.save(cmd);
        double total= getTotal(cmd);
        cmd.setTotal(total);
       cmd= commandeRepository.save(cmd);
        for (Map.Entry<Long,LigneCommande> ligneCommandeEntry : items.entrySet())
             {
                 Article a = ligneCommandeEntry.getValue().getArticle();
                 long q = ligneCommandeEntry.getValue().getQuantite();
                 mouvStockService.sortiArticle(a, q);
             }
        return  cmd;
    }

    @Override
    public double getTotal(Commande commande) {
        double total= 0;
        for (Map.Entry<Long,LigneCommande> entry : commande.getItems().entrySet()) {
            int q= entry.getValue().getQuantite();
            double p = entry.getValue().getArticle().getPrix();
           total += q*p;
    }
        return total;
    }


    @Override
    public List<Commande> getAllCommandesClient(String username) {
        AppUser user = userRepository.findByUsername(username);
        List<Commande> commandes = commandeRepository.findByUserId(user.getId());
        return commandes;
    }

    @Override
    public Page<Commande> getHistoryCommandes() {
        List<Commande> commandes = commandeRepository.findAll();
        Page<Commande> commandesPage = new PageImpl<>(commandes);
        return commandesPage;
    }

    @Override
    public Commande payerCommande(Long idCommande, String username, Adresse adresse) {
        AppUser user = userRepository.findByUsername(username);
        adresse.setActive(true);
        adresseRepository.save(adresse);
        user.getAdresses().add(adresse);
        Commande c = commandeRepository.findById(idCommande).get();
        /// ici l'opération de payement
        c.setETAT("PAYEE");
       return commandeRepository.save(c);
    }
}

package com.Ecommerce.service;

import com.Ecommerce.dao.*;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class PanierServiceImpl implements PanierService {

    @Autowired
    private ArticleRespository articleRespository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private LigneCommandeRespository ligneCommandeRespository;

    @Override
    public Panier CreatePanier(Long idUser) {
        Panier panier = new Panier();
        AppUser user = userRepository.getOne(idUser);
        //Panier p = panierRepository.save(panier);
        panier.setUser(user);
        return panierRepository.save(panier);
    }

    @Override
    public LigneCommande AddArticlePanier(String username, Article a) throws Exception {
        AppUser u = userRepository.findByUsername(username);
        Panier p = panierRepository.findByUserId(u.getId());
        LigneCommande item = null;
        Map<Long, LigneCommande> items = p.getItems();
        item = items.get(a.getId());

      //  if(a.getQuantity()-item.getQuantite() == 0) throw new Exception("il n'y a plus de cette article << non disponible >>");

            if (item == null) {
                System.out.println("if articles == null");

                    item = new LigneCommande();
                    item.setQuantite(1);
                    item.setArticle(a);
                    item = ligneCommandeRespository.save(item);
                    p.getItems().put(a.getId(), item);
                    panierRepository.save(p);
                    System.out.println("neuveau article et sortir");
                return item;

            } else {
                System.out.println(" Article exist");
                item.setQuantite(item.getQuantite() + 1);
                item = ligneCommandeRespository.save(item);
                p.getItems().put(a.getId(), item);
                panierRepository.save(p);
                ligneCommandeRespository.save(item);

                System.out.println("Incrumenter de la quantity de l'Article");
				System.out.println("il n'y a plus de cette article << non disponible >>");
                return item;
                }

    }


    @Override
    public void modifierQuantity(Long idArticle) {
        LigneCommande lc = ligneCommandeRespository.getOne(idArticle);
        if (lc.getQuantite() == 1) {
            ligneCommandeRespository.deleteById(idArticle);
        } else if (lc.getQuantite() > 1) {
            int q = lc.getQuantite() - 1;
            lc.setQuantite(q);
            ligneCommandeRespository.save(lc);
        } else {

        }


    }

    @Override
    public void DeleteArticlePanier(String username, Long idArticle) {
        AppUser u = userRepository.findByUsername(username);
        LigneCommande l = ligneCommandeRespository.findById(idArticle).get();
        Panier p = panierRepository.findByUserId(u.getId());
        Map<Long, LigneCommande> items = p.getItems();
        items.remove(idArticle);
        ligneCommandeRespository.delete(l);
        panierRepository.save(p);

    }

    @Override
    public LigneCommande UpdateArticlePanier(LigneCommande article) {
        return ligneCommandeRespository.save(article);
    }

    @Override
    public LigneCommande getArticlePanier(Long id) {
        return ligneCommandeRespository.getOne(id);

    }

    @Override
    public Map<Long, LigneCommande> getAllArticlesPanier(String username) {
        AppUser user = userRepository.findByUsername(username);
        System.out.println(user);
        Panier p = panierRepository.findByUserId(user.getId());
        p.setItems(p.getItems());
        p= panierRepository.save(p);
        return p.getItems();


    }

    public double getTotal(String username) {
        AppUser user = userRepository.findByUsername(username);
        Panier p = panierRepository.findByUserId(user.getId());
        Map<Long, LigneCommande> items = p.getItems();
        double total = 0;
        for (LigneCommande lc : items.values()) {
            total += lc.getArticle().getPrix() * lc.getQuantite();
        }
        return total;
    }


    @Override
    public void deleteAllArticlesPanier(Long idPanier) {
        Panier p = panierRepository.getOne(idPanier);
        p.getItems().clear();
        panierRepository.save(p);

    }

    @Override
    public Map<Long, LigneCommande> getAllPanier(Long id) {
        AppUser user = userRepository.findById(id).get();
        Panier p = panierRepository.findByUserId(user.getId());
        return p.getItems();
    }

}

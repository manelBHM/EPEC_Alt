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
    public LigneCommande AddArticlePanier(String username, Article a) {
        AppUser u = userRepository.findByUsername(username);
        Panier p = panierRepository.findByUserId(u.getId());
        if(a.getQuantity() < 1){
            return null;
        }
        LigneCommande item = null;
        Map<Long, LigneCommande> items = p.getItems();
        item = items.get(a.getIdArticle());
        if (item == null) {
            System.out.println("if articles == null");
            if (a.getQuantity() > 0) {
                item = new LigneCommande();
                item.setQuantite(1);
                item.setArticle(a);
                item = ligneCommandeRespository.save(item);
                p.getItems().put(a.getIdArticle(), item);
                panierRepository.save(p);
                item = ligneCommandeRespository.save(item);
                System.out.println("neuveau article et sortir");
            } //LigneCommande ar = ligneCommandeRespository.save(item); // arCom = ligneCommandeRespository.save(item);
            else {
                System.out.println("il n'y a plus de cette article << non disponible >>");
                return null;
            }
        } else {
                System.out.println(" Article exist");
            if (a.getQuantity() > 0) {
                item.setQuantite(item.getQuantite() + 1);
                item = ligneCommandeRespository.save(item);
                p.getItems().put(a.getIdArticle(), item);
                panierRepository.save(p);
                ligneCommandeRespository.save(item);
                System.out.println("Incrumenter de la quantity de l'Article");
            } else {
				System.out.println("il n'y a plus de cette article << non disponible >>");
				return null;
			        }
                }
        return item;
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
    public void DeleteArticlePanier(Long idPanier, Long idArticle) {
        Panier p = panierRepository.getOne(idPanier);
        Map<Long, LigneCommande> items = p.getItems();
        items.remove(idArticle);
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
        return p.getItems();


    }

    public double getTotal(Long idPanier) {
        Panier p = panierRepository.getOne(idPanier);
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

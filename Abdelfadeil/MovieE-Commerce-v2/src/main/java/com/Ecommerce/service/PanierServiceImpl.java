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
	private AdresseRepository adresseRepository;
	@Autowired
	private PanierRepository panierRepository;
	@Autowired
	private LigneCommandeRespository ligneCommandeRespository;

	@Override
	public Panier CreatePanier(Long idUser) {
		Panier panier = new Panier();
		AppUser user = userRepository.getOne(idUser);
		Panier p = panierRepository.save(panier);
		p.setUser(user);
		return panierRepository.save(p);
	}

	@Override
	public LigneCommande AddArticlePanier(String username, Article a) {
		AppUser u = userRepository.findByUsername(username);
		Panier p = panierRepository.findByUserId(u.getId());
		LigneCommande arCom = null;
		Map<Long, LigneCommande> items = p.getItems();
		LigneCommande lc = items.get(a.getIdArticle());
		if (lc == null) {
			System.out.println("if articles == null");
			LigneCommande nArticle = new LigneCommande();
			nArticle.setQuantite(1);
			LigneCommande ar = ligneCommandeRespository.save(nArticle);
			nArticle.setArticle(a);
			p.getItems().put(a.getIdArticle(), ar);
			arCom = ligneCommandeRespository.save(ar);
			panierRepository.save(p);
			System.out.println("neuveau article et sortir");

		} else {
			System.out.println(" Article exist");
			lc.setQuantite(lc.getQuantite() + 1);
			arCom = ligneCommandeRespository.save(lc);
			p.getItems().put(a.getIdArticle(), arCom);
			panierRepository.save(p);
			System.out.println("Incrumenter de la quantity de l'Article");
		}

		return arCom;
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
	public Map<Long, LigneCommande> getAllArticlesPanier( String username) {
		AppUser user = userRepository.findByUsername(username);
		System.out.println(user);
		Panier p=panierRepository.findByUserId(user.getId());
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

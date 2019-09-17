package com.Ecommerce.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Ecommerce.dao.AdresseRepository;
import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.CategoryRepository;
import com.Ecommerce.dao.LigneCommandeRespository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;

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
		p.setAppUser(user);
		return panierRepository.save(p);
	}

	@Override
	public LigneCommande AddArticlePanier(Long userId, Article a) {
		Panier p = panierRepository.getOne(userId);
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
	public List<LigneCommande> getAllArticlesPanier(Long idPanier) {
		Panier p = panierRepository.getOne(idPanier);
		List<LigneCommande> list= new ArrayList<LigneCommande>();
		Map<Long, LigneCommande> map = p.getItems();
		map.forEach((key, value) -> {
		   // System.out.println("Key : " + key + " Value : " + value);
			list.add(value);
		});
		 
		  return list;

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
	public Collection<LigneCommande> getAllPanierPage(Long id) {
		Panier p = panierRepository.findByAppUserId(id);
		return p.getItems().values();
	}

}

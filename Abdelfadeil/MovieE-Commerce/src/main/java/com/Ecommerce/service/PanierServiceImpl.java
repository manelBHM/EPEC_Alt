package com.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Ecommerce.dao.AdresseRepository;
import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.CategoryRepository;
import com.Ecommerce.dao.LigneCommandeRespository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;

@Service
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
		Panier panier= new Panier();
		AppUser user = userRepository.findOne(idUser);
		Panier p= panierRepository.save(panier);
		p.setUser(user);
		return panierRepository.save(p);
	}

	@Override
	public LigneCommande AddArticle(LigneCommande article, Long idPanier) {
		Panier p= panierRepository.findOne(idPanier);
		LigneCommande ar= ligneCommandeRespository.save(article);
		p.getItems().add(ar);
		panierRepository.save(p);
		return ar;
	}

	@Override
	public void DeleteArtcle(Long idArticle) {
		LigneCommande lc =ligneCommandeRespository.findOne(idArticle);
		if(lc.getQuantite() == 1) {
			ligneCommandeRespository.delete(idArticle);
		}
		else if(lc.getQuantite() > 1){	
			int q = lc.getQuantite()- 1;
			lc.setQuantite(q);
			ligneCommandeRespository.save(lc);
		}else {
			
		}

	}

	@Override
	public LigneCommande UpdateArticle(LigneCommande article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommande getArticle(Long id) {
		return ligneCommandeRespository.findOne(id);
		
	}

	@Override
	public Page<LigneCommande> getAllArticles(Long idPanier) {
		// TODO Auto-generated method stub
		return null;
	}

}

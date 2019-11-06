package com.Ecommerce.controller;

import com.Ecommerce.dao.IFlickr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.entities.Article;
import com.Ecommerce.dao.ArticleRespository;

import java.io.InputStream;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ArticleController {
	
	
	
	@Autowired
	private ArticleRespository articleRespository;

    public IFlickr flickr;
    void ArticleController(IFlickr flickr) {
        this.flickr=flickr;
    }

	@GetMapping("/get-articles")
	public Page<Article> getArticles(
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="15") int size
			) {
        List<Article> articles = articleRespository.findAll();
        Page<Article> pagesArticles = new PageImpl<>(articles);
		return pagesArticles;
	}
	
	@GetMapping("/get-articles-pages")
	public Page<Article> getArticles(
			@RequestParam(name = "mc", value="") String mc,
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="15") int size			
			) {
		return articleRespository.findByDescriptionContains(mc,PageRequest.of(page, size));
	}
	
	@GetMapping("/get-articles-category/{id}")
	public Page<Article> getArticlesParCategory(
			@PathVariable Long id,
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="15") int size			
			) {
		return articleRespository.findByCategoryIdCategory(id, PageRequest.of(page, size));
	}
	
	@GetMapping("/articles-category-mc/{idCategory}")
	public Page<Article> getArticlesParCategoryMotCle(
			@PathVariable Long idCategory,
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="15") int size,
			@RequestParam(name = "mc", value="") String mc
			) {
		return articleRespository.findByCategoryIdCategoryAndDescriptionContains(idCategory, mc, PageRequest.of(page, size));
	}	
	
	@GetMapping("/get-article/{id}")
	public Article getArticle(@PathVariable Long id) {
		return articleRespository.getOne(id);
	}

	@PostMapping("/add-article")
	public Article save(@RequestBody Article a, @RequestBody InputStream inputStream, @RequestParam(name = "nameFile") String nameFile) {
        try {
            String urlPhoto=  flickr.savePhoto(inputStream, nameFile);
            a.setPhoto(urlPhoto);
            return articleRespository.save(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
	}
	@DeleteMapping("/delete-article/{id}")
	public void deleteArticle(@PathVariable Long id) {
		articleRespository.deleteById(id);
	}
	
	@PutMapping("modifier-article")
	public Article modifierArticle(@RequestBody Article article, @RequestBody InputStream inputStream, @RequestParam(name = "nameFile") String nameFile) {
		Article a =	articleRespository.getOne(article.getIdArticle());
		a.setIdArticle(article.getIdArticle());
		a.setName(article.getName());
		a.setDescription(article.getDescription());
		a.setPrix(article.getPrix());
		//a.setQuantity(article.getQuantity());
		a.setDisponible(article.isDisponible());
        try {
            String urlPhoto=  flickr.savePhoto(inputStream, nameFile);
            a.setPhoto(urlPhoto);
            return articleRespository.save(a);

        } catch (Exception e) {
            e.printStackTrace();
        }

		//Category c = categoryRepository.findByName(article)
		return articleRespository.save(a);
	}
	@PostMapping("/save-photo")
	public String chageAndSavePhoto(@RequestBody InputStream inputStream, @RequestParam(name = "nameFile") String nameFile, @RequestBody Article a) {
        try {
            String urlPhoto=  flickr.savePhoto(inputStream, nameFile);
            a.setPhoto(urlPhoto);
            articleRespository.save(a);
            return urlPhoto;
        } catch (Exception e) {
           e.printStackTrace();
        }
       return "erreur pendant de sacegarde ... ! ";
    }

}

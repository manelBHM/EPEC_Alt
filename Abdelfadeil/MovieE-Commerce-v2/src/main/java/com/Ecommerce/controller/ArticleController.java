package com.Ecommerce.controller;

import com.Ecommerce.TestLog4j1;
import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.entities.Article;
import com.Ecommerce.service.IFlickrService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ArticleController {

    private static Logger logger = Logger.getLogger(TestLog4j1.class);

    @Autowired
    public IFlickrService flickrService;
    @Autowired
	private ArticleRespository articleRespository;



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
	public Article save(@RequestBody Article a) {
            return articleRespository.save(a);
	}
	@DeleteMapping("/delete-article/{id}")
	public void deleteArticle(@PathVariable Long id) {
		articleRespository.deleteById(id);
	}
	
	@PutMapping("modifier-article")
	public Article modifierArticle(@RequestBody Article a) {
            return articleRespository.save(a);
        }

	@PostMapping("/save-photo/{idArticle}")
	public String chageAndSavePhoto(@RequestParam MultipartFile file, @PathVariable("idArticle") Long idArticle) throws IOException {
        InputStream inputStream = file.getInputStream();
        String nameFile= file.getName();
        try {
           Article a = articleRespository.getOne(idArticle);
            String urlPhoto=  flickrService.savePhoto(inputStream, nameFile);
            a.setPhoto(urlPhoto);
            articleRespository.save(a);
            logger.trace("photo saved successfly "+urlPhoto);
            return urlPhoto;
        } catch (Exception e) {
           e.printStackTrace();
        }
       return "erreur pendant de sacegarde ... ! ";
    }



}

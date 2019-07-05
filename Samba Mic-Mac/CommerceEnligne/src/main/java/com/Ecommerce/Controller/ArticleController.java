package com.Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dao.ArticleRepository;
import com.Ecommerce.entities.Article;

@RestController
public class ArticleController {
	@Autowired
	private ArticleRepository articleRepository;
	
	
	@GetMapping("/articles")
	public List<Article> listArticle(){
	return articleRepository.findAll();
	}
	
	@PostMapping("/articles")
	public Article save(@RequestBody Article article){
	return articleRepository.save(article);
	}
	
	@PutMapping("/articles")
	public Article update(@RequestBody Article article){
	return articleRepository.saveAndFlush(article);
	}
	
	@DeleteMapping("/articles")
	public void update(@RequestParam Long idArticle){
	articleRepository.deleteById(idArticle);
	}
	

}

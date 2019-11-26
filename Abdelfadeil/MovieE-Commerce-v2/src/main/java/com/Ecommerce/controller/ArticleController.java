package com.Ecommerce.controller;

import com.Ecommerce.TestLog4j1;
import com.Ecommerce.entities.Article;
import com.Ecommerce.service.IArticleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/article")
public class ArticleController {

    private static Logger logger = Logger.getLogger(TestLog4j1.class);

    @Autowired
    private IArticleService articleService;

	@PostMapping(value="/add-article")
	public Article save( @RequestBody Article article) {

		return articleService.AddArticle(article);
	}

	@PutMapping("/modifier-article-image")
	public Article modifierArticle(@RequestParam MultipartFile file, @RequestBody Article a) {
		return articleService.UpdateArticle(file, a);
	}

    @PutMapping("/modifier-article")
    public Article modifierArticle(@RequestBody Article a) {
        return articleService.AddArticle(a);
    }

	@GetMapping("/get-article")
	public Article getArticle(@RequestParam(name="id") Long id) {
		return articleService.getArticle(id);
	}

    @GetMapping("/get-articles")
    public Page<Article> getArticles(
            @RequestParam(name = "mc", value = "") String mc,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size
    ) {
        return articleService.getAllArticles(mc, page, size);
    }


    @GetMapping("/get-articles-category")
    public Page<Article> getArticlesParCategory(
            @RequestParam(name="id") Long id,
            @RequestParam(name = "mc", defaultValue = "") String mc,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size
    ) {
        return articleService.getArticlesParCtegory(id, mc, page, size);
    }

    @GetMapping("/articles-category-mc")
    public Page<Article> getArticlesParCategoryMotCle(
            @RequestParam("id") Long id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size,
            @RequestParam(name = "mc", value = "") String mc
    ) {
        return articleService.getArticlesParCtegory(id, mc, page, size);
    }

    @DeleteMapping("/delete-article")
    public boolean deleteArticle(@RequestParam("id") Long id) {
        return articleService.deleteArticle(id);
    }

    @PostMapping("/save-photo/{id}")
    public String chageAndSavePhoto(@RequestParam MultipartFile file, @PathVariable("id") Long id) {
        return articleService.uploadImageProduct(file, id);
    }


}

package com.Ecommerce.controller;

import com.Ecommerce.TestLog4j1;
import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.entities.Article;
import com.Ecommerce.service.IArticleService;
import com.Ecommerce.service.IFlickrService;
import com.Ecommerce.service.MouvStockService;
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
    private IArticleService articleService;

	@PostMapping("/add-article")
	public Article save(@RequestParam MultipartFile file, @RequestBody Article a) {
		return articleService.AddArticle(file, a);
	}

	@PutMapping("modifier-article")
	public Article modifierArticle(@RequestParam MultipartFile file, @RequestBody Article a) {
		return articleService.UpdateArticle(file, a);
	}

	@GetMapping("/get-article/{id}")
	public Article getArticle(@PathVariable Long id) {
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


    @GetMapping("/get-articles-category/{id}")
    public Page<Article> getArticlesParCategory(
            @PathVariable Long id,
            @RequestParam(name = "mc", defaultValue = "") String mc,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size
    ) {
        return articleService.getArticlesParCtegory(id, mc, page, size);
    }

    @GetMapping("/articles-category-mc/{id}")
    public Page<Article> getArticlesParCategoryMotCle(
            @PathVariable Long id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size,
            @RequestParam(name = "mc", value = "") String mc
    ) {
        return articleService.getArticlesParCtegory(id, mc, page, size);
    }

    @DeleteMapping("/delete-article/{id}")
    public boolean deleteArticle(@PathVariable Long id) {
        return articleService.deleteArticle(id);
    }

    @PostMapping("/save-photo/{id}")
    public String chageAndSavePhoto(@RequestParam MultipartFile file, @PathVariable("id") Long id) {
        return articleService.uploadImageProduct(file, id);
    }


}

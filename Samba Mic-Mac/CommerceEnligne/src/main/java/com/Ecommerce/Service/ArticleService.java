package com.Ecommerce.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Ecommerce.dao.ArticleRepository;
import com.Ecommerce.dao.CategoryRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.Category;
import com.Ecommerce.entities.User;

@Service
public class ArticleService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Article addArticleToUser(User u, Article article) {
		
		u.getArticles().add(article);
		 userRepository.saveAndFlush(u);
		 return article;
	}

	public Page<Article> findArticleByCategory(Long idCat, Pageable pageable) {
		return articleRepository.findByCategory(idCat, pageable);
	}
	
	public Article addArticleToCategory(Long idCategory , Article article) {
	Category category = categoryRepository.getOne(idCategory);
		article.setCategory(category);
		 articleRepository.saveAndFlush(article);
		 return article;
	}

}

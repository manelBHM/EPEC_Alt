package com.Ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Ecommerce.entities.AppRole;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.Category;
import com.Ecommerce.entities.Commande;
import com.Ecommerce.entities.Pannier;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.CategoryRepository;

@Transactional
@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner{

	
	@Autowired
	private RepositoryRestConfiguration config;
	@Autowired
	private ArticleRespository articleRespository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Article.class, Category.class, Commande.class, Pannier.class,  AppUser.class);

		
		
		/*
		 * accountService.saveRole(new AppRole(null,"USER")); //
		 * accountService.saveRole(new AppRole(null,"ADMIN")); //
		 * accountService.saveUser(new AppUser(null,"user","1234", null)); //
		 * accountService.saveUser(new AppUser(null,"admin","1234", null)); //
		 * accountService.addRoleToUser("user", "USER"); //
		 * accountService.addRoleToUser("admin", "USER"); //
		 * accountService.addRoleToUser("admin", "ADMIN");
		 * 
		 * articleRespository.findAll().forEach(a-> { System.out.println(a); });
		 */
		/*
		 * List<Article> liste= new ArrayList<>(); Random rn = new Random();
		 * 
		 * 
		 * 
		 * for (int i = 0; i < 3; i++) { Category c1 = new Category();
		 * c1.setName(rn.toString()); c1.setDescription(rn.toString());
		 * categoryRepository.save(c1); for (int x = 0; x < 10; x++) { Article a = new
		 * Article(); a.setName(rn.toString()); a.setDescription(rn.toString());
		 * a.setPrice(rn.nextInt()*100); a.setQuantity(rn.nextInt()); a.setCategory(c1);
		 * articleRespository.save(a);
		 * 
		 * } liste = articleRespository.findByCategory(c1);
		 * 
		 * }
		 */
		/*
		 * for (Article article : liste) { System.out.println(article.toString());
		 * 
		 * }
		 */
		
	//	Category c1 = categoryRepository.findOne(1L);
		List<Article> liste= new ArrayList<>();
		Category c = categoryRepository.findOne(8L);
	liste=	articleRespository.findByCategory(c, new PageRequest(0, 20)).getContent();
		//liste = articleRespository.findByCategory(c);
		for (Article article : liste) { 
			System.out.println(article.getIdArticle());
		}
		
			
		}

		  @Bean
			public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
			}
}

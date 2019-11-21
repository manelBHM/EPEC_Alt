package com.Ecommerce.service;

import com.Ecommerce.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

public interface IArticleService {

    public Article AddArticle(MultipartFile file, Article a );
    public Article UpdateArticle(MultipartFile file, Article a);
    public Article getArticle(Long id);
    public boolean deleteArticle(Long id);
    public Page<Article> getAllArticles(String mc, int page, int size);
    public Page<Article> getArticlesParCtegory(Long id, String mc, int page, int size);
    public Page<Article> getArticlesParCategoryAndKeyWord(Long id,  String mc, int page, int size);
    public String uploadImageProduct(MultipartFile file, Long idArticle);
}

package com.Ecommerce.service;

import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.entities.Article;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {


    @Autowired
    public IFlickrService flickrService;
    @Autowired
    private ArticleRespository articleRespository;
    @Autowired
    private MouvStockService mouvStockService;

  Logger logger = Logger.getLogger(ArticleServiceImpl.class);



    @Override
    public Article AddArticle(MultipartFile file, Article a) {
        //a= articleRespository.save(a);
        try {
            InputStream inputStream = file.getInputStream();
            String nameFile= file.getName();
            String urlPhoto=  flickrService.savePhoto(inputStream, nameFile);
            a.setPhoto(urlPhoto);
            //articleRespository.save(a);
            logger.trace("photo saved successfly "+urlPhoto);
        } catch (IOException e) {
            logger.trace("photo not saved  "+e);
        } catch (Exception e) {
            logger.trace("erreur de sevgarde  "+e);
        }
        mouvStockService.enteeArticle(a, a.getQuantity());
        return a;
    }

    public Article AddArticle( Article a) {
       // a= articleRespository.save(a);
        mouvStockService.enteeArticle(a, a.getQuantity());
        return a;
    }

    @Override
    public Article UpdateArticle(MultipartFile file, Article a) {
        a= articleRespository.save(a);
        try {
            InputStream inputStream = file.getInputStream();
            String nameFile= file.getName();
            String urlPhoto=  flickrService.savePhoto(inputStream, nameFile);
            a.setPhoto(urlPhoto);
            articleRespository.save(a);
            logger.trace("photo saved successfly "+urlPhoto);
        } catch (IOException e) {
            logger.trace("photo not saved  "+e);
        } catch (Exception e) {
            logger.trace("erreur de sevgarde  "+e);
        }
        mouvStockService.enteeArticle(a, a.getQuantity());
        return a;
    }

    @Override
    public Article getArticle(Long id) {
        return articleRespository.getOne(id);
    }

    @Override
    public boolean deleteArticle(Long id) {
        try {
            Article a= articleRespository.findById(id).get();
            mouvStockService.sortiArticle(a, a.getQuantity());
            articleRespository.deleteById(id);

        }catch (Exception e){
            e.getStackTrace();
        }
        return true;
    }

    @Override
    public Page<Article> getAllArticles(String mc, int page, int size) {
        return articleRespository.findByDescriptionContains(mc,PageRequest.of(page, size));
    }

    @Override
    public Page<Article> getArticlesParCtegory(Long id, String mc, int page, int size) {
        return articleRespository.findByCategoryIdCategory(id, PageRequest.of(page, size));
    }

    @Override
    public Page<Article> getArticlesParCategoryAndKeyWord(Long id, String mc, int page, int size) {
        return articleRespository.findByCategoryIdCategory(id, PageRequest.of(page, size));
    }

    @Override
    public String uploadImageProduct(MultipartFile file, Long idArticle) {

        try {
            InputStream inputStream = file.getInputStream();
            String nameFile= file.getName();
            Article a = articleRespository.getOne(idArticle);
            String urlPhoto=  flickrService.savePhoto(inputStream, nameFile);
            a.setPhoto(urlPhoto);
            articleRespository.save(a);
            logger.trace("photo saved successfly "+urlPhoto);
            return urlPhoto;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "erreur pendant de sacegarde ... ! ";
    }
}


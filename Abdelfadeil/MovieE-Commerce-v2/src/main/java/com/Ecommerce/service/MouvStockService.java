package com.Ecommerce.service;


import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.MovementStockRepository;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.MouvementStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class MouvStockService {

    @Autowired
    public MovementStockRepository stockRepository;
    @Autowired
    public ArticleRespository articleRespository;


    public MouvementStock enteeArticle(Article article, long quantityEntree) {
        MouvementStock mv = new MouvementStock(article, quantityEntree);
        mv.setTypeMvt(MouvementStock.ENTREE);
        long q = article.getQuantity() + quantityEntree;
        article.setQuantity(q);
        articleRespository.save(article);
        return stockRepository.save(mv);
    }

    public MouvementStock sortiArticle(Article article, long quantitySorti) {
        MouvementStock mv = new MouvementStock(article, quantitySorti);
        mv.setTypeMvt(MouvementStock.SORTIE);
        long q = article.getQuantity() - quantitySorti;
        article.setQuantity(q);
        articleRespository.save(article);
        return stockRepository.save(mv);
    }
}

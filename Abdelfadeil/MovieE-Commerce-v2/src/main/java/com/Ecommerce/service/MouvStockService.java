package com.Ecommerce.service;


import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.MovementStockRepository;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.MouvementStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MouvStockService {

    @Autowired
    public MovementStockRepository stockRepository;
    @Autowired
    public ArticleRespository articleRespository;


    public MouvementStock enteeArticle(Article article, float quantity) {
        MouvementStock mv = new MouvementStock(article, quantity);
            mv.setTypeMvt(MouvementStock.ENTREE);
            return stockRepository.save(mv);

    }

    public MouvementStock sortiArticle(Article article, float quantitySorti) {
        MouvementStock mv = new MouvementStock(article, quantitySorti);
        mv.setTypeMvt(MouvementStock.SORTIE);
        float q = article.getQuantity() - quantitySorti;
        article.setQuantity(q);
        articleRespository.save(article);
        return stockRepository.save(mv);
    }
}

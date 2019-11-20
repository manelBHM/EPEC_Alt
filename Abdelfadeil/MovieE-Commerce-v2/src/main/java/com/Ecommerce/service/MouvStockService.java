package com.Ecommerce.service;


import com.Ecommerce.dao.MovementStockRepository;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.MovementStock;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MouvStockService {

    public MovementStockRepository stockRepository;


    public MovementStock enteeArticle(Article article, BigDecimal quantityEntree) {
        MovementStock mv = new MovementStock(article, quantityEntree);
        mv.setTypeMvt(MovementStock.ENTREE);
        return null;
    }

    public MovementStock sortiArticle(Article article, BigDecimal quantitySorti) {
        MovementStock mv = new MovementStock(article, quantitySorti);
        mv.setTypeMvt(MovementStock.SORTIE);
        return null;
    }
}

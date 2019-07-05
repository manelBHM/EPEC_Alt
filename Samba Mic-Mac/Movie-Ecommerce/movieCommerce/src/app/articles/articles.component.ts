import { Component, OnInit } from '@angular/core';
import { CommandeArticle } from '../model/commandeArticle';
import { Article } from '../model/article';
import { Subscription } from 'rxjs';
import { EcommercesService } from '../ecommerces.service';
import { Commande } from '../model/commande';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {


  commandeArticle: CommandeArticle[] = [];
    articles : Article[] = [];
    selecteCommandeArticle: CommandeArticle;
    private pannierCommande: Commande;
    sub: Subscription;
    productSelected: boolean = false;
 
  constructor() { }

  ngOnInit() {
  }
/* 
  loadProducts() {
    this.ecommerceService.getAllProducts()
        .subscribe(
            (articles: any[]) => {
                this.articles =  articles;
                this.articles .forEach(article => {
                    this.commandeArticle.push(new Commande(article, 0));
                })
            },
            (error) => console.log(error)
        );
}

loadOrders() {
    this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
        this.pannierCommande = this.ecommerceService.ProductOrders;
    });
}
 */

}

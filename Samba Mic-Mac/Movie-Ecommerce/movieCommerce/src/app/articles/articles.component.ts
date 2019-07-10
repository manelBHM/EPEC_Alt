import { Component, OnInit, NgModule } from '@angular/core';
import { ArticleService } from '../services/article.service';
import { Router } from '@angular/router';

@NgModule()
@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  boucles:number[]= [1,2,3,4,5,6,7,8,9,10,11,12, 13,14, 15, 16, 17, 18, 19, 20];
  currentPage:number=0;
  page:number=0;
  size:number=20;
  totalPages: number;
  pages: number[];
  currentMotCle: String="";
  articles:any;


  constructor(private articleService:ArticleService, private router:Router) { }

  ngOnInit() {
    this.chercherArticles();
  }

  chercherArticles() {
    this.articleService.getArticles(this.currentMotCle, this.currentPage, this.size).subscribe(data=> {
      console.log(data);
     // this.totalPages=data["page"].totalPages;
    //  this.pages= new Array<number>(this.totalPages);
      this.articles=data;
  
    }, err=> {
      console.log(err);
    })
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

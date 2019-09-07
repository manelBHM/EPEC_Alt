import { Component, OnInit } from '@angular/core';
import { Route, ActivatedRoute, Router, NavigationEnd } from '@angular/router';
import { ArticleServiceService } from '../service/article-service.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {
  listPanier;
  article;
  id;
  url: string;

  constructor(private router:Router, private articleService:ArticleServiceService, private activatedRoute:ActivatedRoute) { 
    this.router.events.subscribe( val => {
      if(val instanceof NavigationEnd) {
        this.url = val.url;
        console.log(this.url);
        this.id= this.activatedRoute.snapshot.params.id;

      }
    })
    
  }

  ngOnInit() {
    this.getAllArticlePanier(this.id);
  }


  getAllArticlePanier(id){
    this.articleService.getAllCartProducts(id).subscribe(data=> {
      this.listPanier=data;
      console.log(this.listPanier);
    }, error => {
      console.log(error);
    })
  }
  
  afficherArticle(id){
    this.articleService.getArticle(id).subscribe(data=> {
      this.article=data;
      console.log(this.article);
    }, error=> {
      console.log(error);
    })
  }

  supprimerArticlePanier(id){
    this.articleService.deleteCartProduct(id);
  }
}

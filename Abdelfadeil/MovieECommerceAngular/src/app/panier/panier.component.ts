import { Component, OnInit } from '@angular/core';
import { Route, ActivatedRoute, Router, NavigationEnd } from '@angular/router';
import { ArticleServiceService } from '../service/article-service.service';
import { PanierService } from '../service/panier.service';
import { AuthentificationService } from '../service/authentification.service';
import { LigneCommandeModule } from '../ligne-commande/ligne-commande.module';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {
  article;
  id;
  url: string;
  articlsPanier :LigneCommandeModule [] =[];

  constructor(private router:Router, private articleService:ArticleServiceService,
     private activatedRoute:ActivatedRoute, private paierService:PanierService,
     private autService:AuthentificationService
     ) { 
    this.router.events.subscribe( val => {
      if(val instanceof NavigationEnd) {
        this.url = val.url;
         console.log(this.articlsPanier);
        this.id= this.activatedRoute.snapshot.params.id;
        this.autService.chargerUserInfo().subscribe(data=> {
          this.autService.user=data;
          console.log("charger user  "+this.autService.user);
          console.log("charger user  "+this.autService.user);
        },error => {
         console.log("charger user error ");
    
        })

      }
    })
    
  }

  ngOnInit() {

    this.getAllArticlePanier(this.autService.user.id);
    this.autService.chargerUserInfo().subscribe(data=> {
      this.autService.user=data;
      console.log("charger user  "+this.autService.user);
      console.log("charger user  "+this.autService.user);
    },error => {
     console.log("charger user error ");

    })
  }


  getAllArticlePanier(id){
   
    this.paierService.getAllPanier(id).subscribe(data=> {
      this.articlsPanier=data;
      console.log(this.articlsPanier);
      console.log(data);

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

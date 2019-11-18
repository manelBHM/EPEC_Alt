import { Component, OnInit } from '@angular/core';
import { Route, ActivatedRoute, Router, NavigationEnd } from '@angular/router';
import { ArticleServiceService } from '../service/article-service.service';
import { PanierService } from '../service/panier.service';
import { AuthentificationService } from '../service/authentification.service';
import { LigneCommandeModule } from '../ligne-commande/ligne-commande.module';
import {ArticleModule} from "../article/article.module";

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {
  article: ArticleModule;
  id: number;
  idUser;
  quantity:number
  url: string;
 public ligneCommandes : Array<LigneCommandeModule> = new Array<LigneCommandeModule>();

  constructor(private router:Router, private articleService:ArticleServiceService,
     private activatedRoute:ActivatedRoute, private paierService:PanierService,
     private autService:AuthentificationService
     ) {
    /*
    this.router.events.subscribe( val => {
      if(val instanceof NavigationEnd) {
        this.url = val.url;
        // console.log(this.ligneCommandes);

        this.id= this.activatedRoute.snapshot.params.id;
         this.autService.chargerUserInfo().subscribe(data => {
      this.autService.user=data;
      this.idUser= this.autService.user.id;
      console.log(this.autService.user);
    })
      }
    })
*/
  }

  ngOnInit() {

    this.getAllArticlePanier();
    /*
   //
    this.getAllArticlePanier(this.autService.user.id);
    this.autService.chargerUserInfo().subscribe(data=> {
      console.log("charger user  "+this.autService.user);
      this.autService.user=data;
    },error => {
     console.log("charger user error ");

    })

     */
  }


  getAllArticlePanier(){

    this.paierService.getAllPanier().subscribe(data=> {
      this.ligneCommandes=data;
      console.log('data ' +data);
     console.log('this.ligneComandes '+this.ligneCommandes);
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

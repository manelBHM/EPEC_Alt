import {Component, IterableDiffers, OnInit} from '@angular/core';
import { Route, ActivatedRoute, Router, NavigationEnd } from '@angular/router';
import { ArticleServiceService } from '../service/article-service.service';
import { PanierService } from '../service/panier.service';
import { AuthentificationService } from '../service/authentification.service';
import { LigneCommandeModule } from '../ligne-commande/ligne-commande.module';
import {ArticleModule} from "../article/article.module";
import {JwtHelper} from "angular2-jwt";
import {iterator} from "rxjs/internal-compatibility";

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
  //  public ligneCommandes : Map<number,LigneCommandeModule> = new Map<number, LigneCommandeModule>();
 public ligneCommandes: Array<LigneCommandeModule>=new Array<LigneCommandeModule>();
    items= new Map<number, LigneCommandeModule>();
  private total: number;
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
    let jwtHelper = new JwtHelper();
    this.autService.username = jwtHelper.decodeToken(this.autService.jwtToken).sub;
    this.getTotal();

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

   getTotal() {
     this.paierService.getTotal().subscribe(data => {
       this.total=data;
     }, error => {
       console.log(error)
     })
     }
  getAllArticlePanier(){

    this.paierService.getAllPanier().subscribe(data=> {
      this.items=data;
      console.log('data map' +this.items);

    // console.log('this.ligneComandes '+this.ligneCommandes);
    }, error => {
      console.log(error);
    })
    this.getTotal();
  }

  afficherArticle(){
    this.articleService.getArticle(this.autService.username).subscribe(data=> {
      this.article=data;
      console.log(this.article);
    }, error=> {
      console.log(error);
    })
  }

  supprimerArticlePanier(id){
    this.paierService.supprimerArticle(id).subscribe(data => {
      console.log(id +"      *****  "+ data);
      this.getAllArticlePanier();
    }, error => {
      console.log(error);
    })

    this.getTotal();


  }
}

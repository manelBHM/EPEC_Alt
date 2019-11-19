import { Component, OnInit, ViewChild, ElementRef  } from '@angular/core';
import { Router } from '@angular/router';
import { ArticleServiceService } from '../service/article-service.service';
import { AuthentificationService } from '../service/authentification.service';
import { JwtHelper } from 'angular2-jwt';
import { UserModule } from '../user/user.module';
import { User } from '../user.model';
import { templateJitUrl } from '@angular/compiler';
import {ArticleModule} from "../article/article.module";
import {LigneCommandeModule} from "../ligne-commande/ligne-commande.module";

declare var $;


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  @ViewChild('dataTable',  {static: false}) table: ElementRef;
  dataTable:any;

  boucles:number[]= [1,2,3,4,5,6,7,8,9,10,11,12, 13,14, 15, 16, 17, 18, 19, 20];
  currentPage:number=0;
  page:number=0;
  size:number=20;
  totalPages: number;
  pages: number[];
  currentMotCle: String="";
  articles:any;
  public  slide: boolean= false;
  tour:number=4;
  public mc:any;
   ligneCommande: LigneCommandeModule;

  constructor(private articleService:ArticleServiceService,
     private router:Router, private autService:AuthentificationService) { }



  ngOnInit() {
     this.chercherArticles();
     console.log(this.autService.username);
  }

  slider(){
    // this.autService.getUserInfo(this.autService.username).subscribe(data => {
    //   let user =data;
    //   this.autService.user=data;
    //   console.log(this.autService.user);
    //  })
//
  }

  ajouterArticlePanier(article:ArticleModule){
    this.articleService.addToCart(article).subscribe(data=> {
      this.ligneCommande=data;
    }, error=> {
      console.log(error);
    })
  }

  chercherArticles() {
    this.articleService.getArticles(this.currentMotCle, this.currentPage, this.size).subscribe(data=> {
      console.log(data);
      this.totalPages=data['totalPages'];
      this.pages= new Array<number>(this.totalPages);
      console.log(this.totalPages);
      this.articles=data;

    }, err=> {
      console.log(err);
      this.autService.logout();
     // this.router.navigateByUrl('/login');
    })


}


onChercher(form:any) {
  this.mc =form;
  this.router.navigateByUrl('/articles/all');

}
}

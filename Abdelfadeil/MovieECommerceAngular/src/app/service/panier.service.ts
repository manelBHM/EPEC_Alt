import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthentificationService } from './authentification.service';
import { LigneCommandeModule } from '../ligne-commande/ligne-commande.module';
import {JwtHelper} from "angular2-jwt";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  host: string="http://localhost:8080";
  private page: number=0;
  private size: number=100;


  constructor(private http:HttpClient, private autService:AuthentificationService) {

  }




  getAllPanier() :Observable<Map<number, LigneCommandeModule>>{
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    let jwtHelper = new JwtHelper();
    this.autService.username = jwtHelper.decodeToken(this.autService.jwtToken).sub;
    return this.http.get<Map<number, LigneCommandeModule>>(this.host+"/panier/get-articles-username?username="+ this.autService.username, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }


  getTotal() :Observable<number>{
    if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
    let jwtHelper = new JwtHelper();
    this.autService.username = jwtHelper.decodeToken(this.autService.jwtToken).sub;
    return this.http.get<number>(this.host+"/panier/get-total?username="+ this.autService.username, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});

  }


  supprimerArticle(id) {
    if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
    let jwtHelper = new JwtHelper();
    this.autService.username = jwtHelper.decodeToken(this.autService.jwtToken).sub;
    return this.http.delete(this.host+"/panier/delete-article?idArticle="+ id+"&username="+ this.autService.username, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});

  }
}

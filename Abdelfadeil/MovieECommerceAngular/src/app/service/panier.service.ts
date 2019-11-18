import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthentificationService } from './authentification.service';
import { LigneCommandeModule } from '../ligne-commande/ligne-commande.module';
import {JwtHelper} from "angular2-jwt";

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  host: string="http://localhost:8080";
  private page: number=0;
  private size: number=100;


  constructor(private http:HttpClient, private autService:AuthentificationService) {

  }




  getAllPanier() {
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    let jwtHelper = new JwtHelper();
    this.autService.username = jwtHelper.decodeToken(this.autService.jwtToken).sub;
    return this.http.get<LigneCommandeModule[]>(this.host+"/panier/getAllArticles-page?username="+ this.autService.username+"&page="+this.page+"&size="+this.size, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }


}

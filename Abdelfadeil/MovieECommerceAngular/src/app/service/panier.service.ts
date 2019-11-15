import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthentificationService } from './authentification.service';
import { LigneCommandeModule } from '../ligne-commande/ligne-commande.module';

@Injectable({
  providedIn: 'root'
})
export class PanierService {
 
  host: string="http://localhost:8080";

  
  constructor(private http:HttpClient, private autService:AuthentificationService) {

  }

 


  getAllPanier(id) {
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    return this.http.get<LigneCommandeModule[]>(this.host+"/panier/getAllArticles-page?id="+ id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }


}

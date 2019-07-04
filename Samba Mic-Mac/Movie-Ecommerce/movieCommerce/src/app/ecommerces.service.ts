import { Injectable } from '@angular/core';
import { Commande } from './model/commande';
import { Subject } from 'rxjs/internal/Subject';
import { HttpClient } from '@angular/common/http';
import { CommandeArticle } from './model/commandeArticle';

@Injectable({
  providedIn: 'root'
})
export class EcommercesService {

  private articleUrl = "/api/products";
  private commandeUrl = "/api/orders";

  private commandeArticle: CommandeArticle;
  private orders: CommandeArticle = new CommandeArticle();

  private commandeArticleSubject = new Subject();
  private commandeSubject = new Subject();
  private totalSubject = new Subject();

  private total: number;

  ProductOrderChanged = this.commandeArticleSubject.asObservable();
  OrdersChanged = this.commandeSubject.asObservable();
  TotalChanged = this.totalSubject.asObservable();

  constructor(private http: HttpClient) {
  }

  getAllProducts() {
      return this.http.get(this.articleUrl);
  }

  saveOrder(commande : Commande) {
      return this.http.post(this.commandeUrl, commande);
  }
  
}

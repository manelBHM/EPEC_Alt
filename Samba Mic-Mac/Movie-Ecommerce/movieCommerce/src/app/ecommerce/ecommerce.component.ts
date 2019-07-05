import { Component, OnInit, ViewChild } from '@angular/core';
import { Article } from '../model/article';
import { ArticlesComponent } from '../articles/articles.component';
import { PannierComponent } from '../pannier/pannier.component';
import { CommandeComponent } from '../commande/commande.component';


@Component({
  selector: 'app-ecommerce',
  templateUrl: './ecommerce.component.html',
  styleUrls: ['./ecommerce.component.css']
})
export class EcommerceComponent implements OnInit {

  constructor(private article: Article) { }

  private collapsed = true;
  orderFinished = false;

  @ViewChild('productsC')
  articleC: ArticlesComponent;

  @ViewChild('shoppingCartC')
  pannierC: PannierComponent;

  @ViewChild('ordersC')
  commandeC: CommandeComponent;

  toggleCollapsed(): void {
      this.collapsed = !this.collapsed;
  }

  finishOrder(orderFinished: boolean) {
      this.orderFinished = orderFinished;
  }

  reset() {
      this.orderFinished = false;
      this.articleC;
      this.pannierC;
      this.commandeC;
  }

  ngOnInit() {
  }

}

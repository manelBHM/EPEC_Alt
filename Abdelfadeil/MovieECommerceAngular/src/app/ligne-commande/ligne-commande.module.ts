import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ArticleModule } from '../article/article.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class LigneCommandeModule { 

  public idLigneCommande:number;
	public  article:ArticleModule;
	public  quantite:number;
  public  prix:number;
  
  constructor(
     idLigneCommande:number,
	   article:ArticleModule,
	   quantite:number,
     prix:number
  ){

  }
}

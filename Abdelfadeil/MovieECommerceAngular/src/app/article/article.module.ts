import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ArticleComponent } from './article.component';



@NgModule({
  declarations: [ArticleComponent],
  imports: [
    CommonModule
  ]
})
export class ArticleModule {
  
  idArticle:number;
  name:String;
  description:String;
  price:number;
  quantity:number;
  photo:String;
  nomCategory:String;
  disponible:boolean;

}

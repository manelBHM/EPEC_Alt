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
  prix:number;
  quantity:number;
  photo:String;
  nomCategory:String;
  disponible:boolean;
  totalPages: number;

}

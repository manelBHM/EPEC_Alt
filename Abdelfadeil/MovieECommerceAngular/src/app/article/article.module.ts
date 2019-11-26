import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ArticleComponent } from './article.component';
import {CategoryModule} from "../category/category.module";



@NgModule({
  declarations: [ArticleComponent],
  imports: [
    CommonModule
  ]
})
export class ArticleModule {

  id:number;
  name:String;
  description:String;
  prix:number;
  quantity:number;
  photo:String;
  category:CategoryModule;
  disponible:boolean;
  totalPages: number;


}

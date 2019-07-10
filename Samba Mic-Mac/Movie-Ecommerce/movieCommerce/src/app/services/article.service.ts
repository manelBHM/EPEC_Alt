import { Injectable, NgModule } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Article } from '../model/article';
import { observable, Observable } from 'rxjs';



@NgModule({})

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  public host: String = "http://localhost:8080";

  constructor(private http:HttpClient) { }


  getArticles(mc:String,page:number, size:number){
     return this.http.get(this.host+"/articles/search/ArticlesPage?mc="+mc+"&page="+page+"&size="+size);
   }

  getArticle(url) {
   return this.http.get(url);
 }
}

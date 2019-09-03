import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthentificationService } from '../authentification.service';
import { ArticlesComponent } from '../articles/articles.component';
import { ArticleModule } from '../article/article.module';

@Injectable({
  providedIn: 'root'
})
export class ArticleServiceService {



   public host: String = "http://localhost:8080";

  constructor(private http:HttpClient, private autService:AuthentificationService) {

   }


  getArticles(mc:String, page:number, size:number){
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
     return this.http.get(this.host+"/get-articles-pages?mc="+mc+"&page="+page+"&size="+size, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
   }




}

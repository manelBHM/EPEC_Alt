import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ArticleModule } from '../article/article.module';
import { AuthentificationService } from './authentification.service';

@Injectable({
  providedIn: 'root'
})
export class ArticleServiceService {
  
  public host: String = "http://localhost:8080";
  
  constructor(private http:HttpClient, private autService:AuthentificationService) {

  }
  
  
  getArticle(id) {
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    return this.http.get<ArticleModule>(this.host+"/get-article/"+id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }
  
  editerArticle(article:ArticleModule){
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    return this.http.put<ArticleModule>(this.host+"/modifier-article", article, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})})
  }
  
   
  
  getArticlesList(){
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    return this.http.get(this.host+"/get-articles/", {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }
   getArticles(mc:String, page:number, size:number){
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    return this.http.get(this.host+"/get-articles-pages?mc="+mc+"&page="+page+"&size="+size, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }
  
   getArticlesCategory(idCategory: number, mc: String, page: number, size: number){
     if(this.autService.jwtToken==null)
     this.autService.jwtToken = this.autService.loadToken();
     return this.http.get(this.host+"/articles-category-mc/"+idCategory+"?mc="+mc+"&page="+page+"&size="+size, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
    }
    
    ajouterArticle(article:ArticleModule) {
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
      return this.http.post(this.host+ "/add-article", article, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
    }
    
    supprimer(id:number){
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
      return this.http.delete(this.host+"/delete-article/"+id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
    }
    
    // partie cart(panier)
    addToCart(article, id) {
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
      return this.http.post(this.host+"/panier/add/"+id, article, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
    }

    getAllCartProducts(id){
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
      return this.http.post(this.host+"/panier/getAllArticlesListPage/"+id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});

    }
    deleteCartProduct(id){
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
     this.http.post(this.host+"/panier/delete/"+id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});

    }

}

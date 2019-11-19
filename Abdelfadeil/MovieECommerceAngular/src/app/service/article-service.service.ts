import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders, HttpRequest} from '@angular/common/http';
import { ArticleModule } from '../article/article.module';
import { AuthentificationService } from './authentification.service';
import { LigneCommandeModule } from '../ligne-commande/ligne-commande.module';
import { Observable } from 'rxjs';
import {JwtHelper} from "angular2-jwt";


@Injectable({
  providedIn: 'root'
})
export class ArticleServiceService {

  public host: String = "http://localhost:8080";

  constructor(private http:HttpClient, private autService:AuthentificationService) {

  }


  getArticle(username) {
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    return this.http.get<ArticleModule>(this.host+"/get-article/"+username, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }

  editerArticle(article:ArticleModule){
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    return this.http.put<ArticleModule>(this.host+"/modifier-article", article, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})})
  }



  getArticlesList(){
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    return this.http.get<ArticleModule>(this.host+"/get-articles/", {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }
   getArticles(mc:String, page:number, size:number){
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    return this.http.get<ArticleModule>(this.host+"/get-articles-pages?mc="+mc+"&page="+page+"&size="+size, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }

   getArticlesCategory(idCategory: number, mc: String, page: number, size: number){
     if(this.autService.jwtToken==null)
     this.autService.jwtToken = this.autService.loadToken();
     return this.http.get<ArticleModule>(this.host+"/articles-category-mc/"+idCategory+"?mc="+mc+"&page="+page+"&size="+size, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
    }

    ajouterArticle(article:ArticleModule) {
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
      return this.http.post<ArticleModule>(this.host+ "/add-article", article , {headers:new HttpHeaders({'Authorization':this.autService.jwtToken})});
    }

    supprimer(id:number){
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
      return this.http.delete(this.host+"/delete-article/"+id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
    }

    // partie cart(panier)
    addToCart(article:ArticleModule) {
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
      let jwtHelper = new JwtHelper();
      this.autService.username = jwtHelper.decodeToken(this.autService.jwtToken).sub;
      return this.http.post<LigneCommandeModule>(this.host+"/panier/add?username="+ this.autService.username , article, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
    }

    getAllCartProducts(id){
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
      return this.http.post<LigneCommandeModule>(this.host+"/panier/getAllArticlesListPage/"+id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});

    }
    deleteCartProduct(id){
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
     this.http.post(this.host+"/panier/delete/"+id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});

    }

  uploadPhoto(file: FormData, idArticle) :Observable<HttpEvent<{}>>{
      if(this.autService.jwtToken==null)
        this.autService.jwtToken = this.autService.loadToken();

    const req = new HttpRequest('POST', this.host+'/save-photo/'+idArticle, file,
      {reportProgress:true, responseType: 'text',
    });
    return this.http.request(req);
    }

}

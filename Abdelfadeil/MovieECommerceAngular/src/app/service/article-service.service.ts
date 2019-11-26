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


  getArticle(id): Observable<any> {
     // if(this.autService.jwtToken==null)
    // this.autService.jwtToken = this.autService.loadToken();
    return this.http.get<ArticleModule>(this.host+"/article/get-article?id="+id);
  }

  editerArticle(article:ArticleModule){
    if(this.autService.jwtToken==null)
    this.autService.jwtToken = this.autService.loadToken();
    return this.http.put<ArticleModule>(this.host+"/article/modifier-article", article, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})})
  }



  getArticlesList(){
     if(this.autService.jwtToken==null)
     this.autService.jwtToken = this.autService.loadToken();
    // {headers:new HttpHeaders({'authorization':this.autService.jwtToken})}
    return this.http.get<ArticleModule>(this.host+"/article/get-articles/");
  }
   getArticles(mc:String, page:number, size:number){
  //  if(this.autService.jwtToken==null)
  //  this.autService.jwtToken = this.autService.loadToken();
     // {headers:new HttpHeaders({'authorization':this.autService.jwtToken})}
    return this.http.get<ArticleModule>(this.host+"/article/get-articles?mc="+mc+"&page="+page+"&size="+size);
  }

   getArticlesCategory(id: number, mc: String, page: number, size: number){
     //  if(this.autService.jwtToken==null)
     //  this.autService.jwtToken = this.autService.loadToken();
     // {headers:new HttpHeaders({'authorization':this.autService.jwtToken})}
     return this.http.get<ArticleModule>(this.host+"/article/get-articles-category?id="+id+"&mc="+mc+"&page="+page+"&size="+size);
    }

    ajouterArticle(article:ArticleModule) {
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
      return this.http.post<ArticleModule>(this.host+ "/article/add-article", article , {headers:new HttpHeaders({'Authorization':this.autService.jwtToken})});
    }

    supprimer(id:number){
      if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
      return this.http.delete(this.host+"/article/delete-article?id="+id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
    }

    // partie cart(panier)
    addToCart(article) {
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
      let jwtHelper = new JwtHelper();
      this.autService.username = jwtHelper.decodeToken(this.autService.jwtToken).sub;
     return this.http.delete(this.host+"/panier/delete?idArticle="+id+"&username="+ this.autService.username, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});

    }

  uploadPhoto(file: FormData, id) :Observable<HttpEvent<{}>>{
      if(this.autService.jwtToken==null)
        this.autService.jwtToken = this.autService.loadToken();
    const req = new HttpRequest('POST', this.host+'/article/save-photo/'+id, file,
      {reportProgress:true, responseType: 'text',
    });
    return this.http.request(req);
    }

  ajouterArticleEtPhoto(file: FormData) {

    const req = new HttpRequest('POST', this.host+'/article/save-photo',file,
      {reportProgress:true, responseType: 'text',
      });

    return this.http.request(req);  }

}

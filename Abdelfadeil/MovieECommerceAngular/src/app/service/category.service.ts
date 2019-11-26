import { Injectable } from '@angular/core';
import { AuthentificationService } from './authentification.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { CategoryModule } from '../category/category.module';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  public host: String = "http://localhost:8080";

  constructor(private http:HttpClient, private autService:AuthentificationService) {

  }


  // getCategory(id) {
  //   if(this.autService.jwtToken==null)
  //   this.autService.jwtToken = this.autService.loadToken();
  //   return this.http.get<CategoryModule>(this.host+"/categories/"+id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  // }

  getCategories(page: number, size: number) :Observable<CategoryModule[]>{
   if(this.autService.jwtToken==null)
   this.autService.jwtToken = this.autService.loadToken();
    return this.http.get<CategoryModule[]>(this.host+"/category/getCategories?page="+page+"&size="+size, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }

  getCategorie(id: number) :Observable<CategoryModule>{
    if(this.autService.jwtToken==null)
      this.autService.jwtToken = this.autService.loadToken();
    return this.http.get<CategoryModule>(this.host+"/category/getCategorie?id="+id, {headers:new HttpHeaders({'authorization':this.autService.jwtToken})});
  }

}

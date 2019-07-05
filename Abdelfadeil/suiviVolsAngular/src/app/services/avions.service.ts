import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AvionModel } from 'src/model/avion.model';

@Injectable({
  providedIn: 'root'
})
export class AvionsService {
  
  public host: String = "http://localhost:8080";
  constructor(private http: HttpClient) { }


  getAvions({ mc, page, size }: { mc: String; page: number; size: number; }) {
    return this.http.get<AvionModel>(this.host+"/avions/search/byModelPage?mc="+mc+"&page="+page+"&size="+size);
  }


  Save( avion:AvionModel) {
       return this.http.post<AvionModel>(this.host+"/avions/", avion);
      
     }
        delete(url) {
          return this.http.delete<AvionModel>(url);
        }

        getAvion(url) {
          return this.http.get<AvionModel>(url);
        }
      
        editerAvion(url,avion:AvionModel){
          return this.http.put<AvionModel>(url, avion);
        }
}


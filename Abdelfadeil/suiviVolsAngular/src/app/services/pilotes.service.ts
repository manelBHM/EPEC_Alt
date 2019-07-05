import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PiloteModel } from 'src/model/Pilote.Model';

@Injectable({
  providedIn: 'root'
})
export class PilotesService {
  

  getPilote(url) {
    return this.http.get(url);
  }

  editerPilote(url,pilote:PiloteModel){
    return this.http.put<PiloteModel>(url, pilote);
  }

  
  public host: String = "http://localhost:8080";
  
  
  constructor(private http: HttpClient) { }
  
  
  getPilotes(){
    return this.http.get<PiloteModel>(this.host+"/pilotes");
  }
  
  Save( pilote:PiloteModel) {
    return this.http.post<PiloteModel>(this.host+"/pilotes/", pilote);
    
  }
      delete(url) {
        return this.http.delete<PiloteModel>(url);
      }
    
      getPilotesByKeyNom(mc:String, page:number, size:number){
        return this.http.get<PiloteModel>(this.host+"/pilotes/search/byNomPage?mc="+mc+"&page="+page+"&size="+size);
        
      }
}

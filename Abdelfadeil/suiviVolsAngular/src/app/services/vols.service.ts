import { Injectable, NgModule } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ModelVol } from 'src/model/Model.vol';
import { observable, Observable } from 'rxjs';


@NgModule({})

@Injectable({
  providedIn: 'root'
})
export class VolsService {
  
   getVol(url) {
    return this.http.get(url);
  }
  // public saveResource(url, data){
  //   return this.http.post(url, data);
  // }
  
  public host: String = "http://localhost:8080";

  
  constructor(private http: HttpClient) { 
    // this.http.get<ModelVol>('http://localhost:8080/vols').subscribe(data => console.log(data))
  }
  
   getVols(page:number, size:number){
    return this.http.get<ModelVol>(this.host+"/vols?page="+page+"&size="+size);
  }
  getVolsByKeyNom(mc:String, page:number, size:number){
    return this.http.get<ModelVol>(this.host+"/vols/search/byNoVolPage?mc="+mc+"&page="+page+"&size="+size);
    
  }


   ajoutVol( vol:ModelVol) {
    return this.http.post<ModelVol>(this.host+"/vols/", vol);
    
  }
  editerVol(url,vol: ModelVol){
    return this.http.put<ModelVol>(url, vol);
  }

  supprimer(url) {
    return this.http.delete<ModelVol>(url);

  }

  
}

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
    this.http.get('http://localhost:8080/listVols').subscribe(data => console.log(data))
  }
  
   getVols(page:number, size:number){
    return this.http.get(this.host+"/listVols?page="+page+"&size="+size);
  }
  getVolsByKeyNom(mc:String, page:number, size:number){
    return this.http.get(this.host+"/vols/search/byNoVolPage?mc="+mc+"&page="+page+"&size="+size);
    
  }


   ajoutVol( vol:ModelVol) {
    return this.http.post(this.host+"/ajoutervol/", vol);
    
  }
  editerVol(url,data){
    return this.http.put(url, data);
  }

  supprimer(url) {
    return this.http.delete(url);

  }

  print(){
    console.log('beeeeeeel')
  }
}

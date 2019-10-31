import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GymnasesService {

  constructor(private http:HttpClient) { }

  getGymnases(){
   return  this.http.get("http://localhost:8080/gymnaseses");
  }

}

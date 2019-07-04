import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Avion } from '../avion';
import { CATCH_ERROR_VAR } from '@angular/compiler/src/output/output_ast';



@Injectable({
  providedIn: 'root'
})
export class AvionService {

  constructor(private http: HttpClient) { }

  private baseUrl = "http://localhost:8090/api/av1/avion"

  getAvion(){
    let token = localStorage.getItem('access_token');
    return this.http.get<Avion[]>(this.baseUrl);
  }

  getAvionById(id: number){
    let token = localStorage.getItem('access_token');
    return this.http.get<Avion>(this.baseUrl + '/' + id);
  }

  createAvion(avion: Avion){
    return this.http.post(this.baseUrl, avion);
  }

  updateAvion(avion: Avion){
    console.log(avion);
    return this.http.post(this.baseUrl, avion);

  }

  deleteAvion(id: number){
    return this.http.delete(this.baseUrl + '/' + id);
  }

}

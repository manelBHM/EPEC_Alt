import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Vol } from '../vol';


@Injectable({
  providedIn: 'root'
})

export class VolService {

  constructor(private http: HttpClient) { }

  private baseUrl = "http://localhost:8090/api/plane/vol";

  getVol(){
    let token = localStorage.getItem('access_token');
   return this.http.get<Vol[]>(this.baseUrl);
  }

  getVolById(id: number){
    let token = localStorage.getItem('access_token');
    return this.http.get<Vol>(this.baseUrl + '/' + id);
  }

  createVol(vol: Vol){
   return  this.http.post(this.baseUrl, vol)
  }

  updateVol(vol: Vol) {
    console.log(vol);
    return this.http.post(this.baseUrl, vol);
  }

  deleteVol(id: number){
   return this.http.delete(this.baseUrl + '/' + id);
  }
  
}

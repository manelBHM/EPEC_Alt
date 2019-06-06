import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type':'application/json'})
}
@Injectable({
  providedIn: 'root'
})
export class PiloteService {

  constructor(private http:HttpClient) { }

  getPilotes(){
    return this.http.get('/server/api/v1/pilotes');
  }

  getPilote(id :number){
    return this.http.get('/server/api/v1/pilotes/' + id);
  }

  createPilote(pilote){
    let body = JSON.stringify(pilote);
    return this.http.post('/server/api/v1/pilotes', body, httpOptions);
  }
}

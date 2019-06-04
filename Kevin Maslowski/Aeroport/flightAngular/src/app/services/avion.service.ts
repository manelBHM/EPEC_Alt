import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AvionService {

  constructor(private http:HttpClient) { }

  getAvions(){
    return this.http.get('/server/avions');
  }

  getAvion(id: number) {
    return this.http.get('/server/avions/' + id)
  }

  createAvionRegistration(avion) {
    let body = JSON.stringify(avion);
    return this.http.post('/server/avions', body, httpOptions);
  }

  saveAvion(avion){
    let body = JSON.stringify(avion);
    return this.http.put('/server/avions/update', body, httpOptions);
  }
}

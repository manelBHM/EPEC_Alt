import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Rx';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PiloteService {

  constructor(private http:HttpClient) { }

  getPilotes(){
    return this.http.get('/server/pilotes');
  }

  getPilote(id: number) {
    return this.http.get('/server/pilotes/' + id)
  }

  createPiloteRegistration(pilote) {
    let body = JSON.stringify(pilote);
    return this.http.post('/server/pilotes', body, httpOptions);
  }
  
  deletePilote(id: number) {
    return this.http.delete('/server/pilotes/' + id)
  }

  savePilote(pilote) {
    let body = JSON.stringify(pilote);
    return this.http.put('/server/pilotes/update', body, httpOptions);
  }


}

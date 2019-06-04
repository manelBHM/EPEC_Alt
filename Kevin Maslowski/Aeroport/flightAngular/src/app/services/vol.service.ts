import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class VolService {

  constructor(private http:HttpClient) { }

  getVols(){
    return this.http.get('/server/vols');
  }

  getVol(id: string){
    return this.http.get('/server/vols/' + id);
  }

  createVolRegistration(vol) {
    let body = JSON.stringify(vol);
    return this.http.post('/server/vols', body, httpOptions);
  }

  getVolsByPilote(pilote: number){
    return this.http.get('/server/vols/listByPilote/' + pilote);
  }

  saveVol(vol){
    let body = JSON.stringify(vol);
    return this.http.put('/server/vols/update', body, httpOptions);
  }



}

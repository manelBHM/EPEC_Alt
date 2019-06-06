import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type':'application/json'})
}
@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http:HttpClient ) { }

  getFlights(){
    return this.http.get('/server/api/v1/vols')
  }

  getFlight(id :number){
    return this.http.get('/server/api/v1/vols/' + id)
  }

  createFlight(flight){
    let body = JSON.stringify(flight);
    return this.http.post('/server/api/v1/vols', body, httpOptions);
  }

  deleteFlight(id:number){
    return this.http.delete('/server/api/v1/vols/' + id);
  }
}

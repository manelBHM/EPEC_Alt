import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type':'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class PlaneService {

  constructor(private http:HttpClient) { }

  getPlanes(){
    return this.http.get('/server/api/v1/planes');
  }

  getPlane(id :number){
    return this.http.get('/server/api/v1/planes/' + id);
  }

  createPlane(plane){
    let body = JSON.stringify(plane);
    return this.http.post('/server/api/v1/planes', body, httpOptions);
  }
}

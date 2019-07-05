import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class DvdService {

  constructor(private http:HttpClient) { }

  getDvds() {
    return this.http.get('http://localhost:8080/dvd');
  }

  getDvd(id: number) {
    return this.http.get('http://localhost:8080/dvd/' + id);
  }

  createDvdRegistration(dvd) {
    let body = JSON.stringify(dvd);
    return this.http.post('http://localhost:8080/dvd', body, httpOptions);
  }

  deleteDvd(id: number) {
    return this.http.delete('http://localhost:8080/dvd/' + id);
  }

  saveDvd(dvd) {
    let body =JSON.stringify(dvd);
    return this.http.put('http://localhost:8080/dvd/update', body, httpOptions);
  }
}

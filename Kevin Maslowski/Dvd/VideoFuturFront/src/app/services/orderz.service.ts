import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  getOrders() {
    return this.http.get('http://localhost:8080/order');
  }

  getOrder(id: number) {
    return this.http.get('http://localhost:8080/order/' + id);
  }

  createOrderRegistration(orderz) {
    let body = JSON.stringify(orderz);
    return this.http.post('http://localhost:8080/order', body, httpOptions);
  }

  deleteOrder(id: number) {
    return this.http.delete('http://localhost:8080/order/' + id);
  }

  saveOrder(orderz) {
    let body = JSON.stringify(orderz);
    return this.http.put('http://localhost:8080/order/update', body, httpOptions);
  }
}

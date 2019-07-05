import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class OrderItemService {

  constructor(private http:HttpClient) { }

  getOrderItems() {
    return this.http.get('http://localhost:8080/orderitem');
  }

  getOrderItem(id: number) {
    return this.http.get('http://localhost:8080/orderitem/' + id);
  }

  createOrderItemRegistration(orderItem) {
    let body = JSON.stringify(orderItem);
    return this.http.post('http://localhost:8080/orderitem', body, httpOptions);
  }

  deleteOrderItem(id: number) {
    return this.http.delete('http://localhost:8080/orderitem/' + id);
  }

  saveOrderItem(orderItem) {
    let body =JSON.stringify(orderItem);
    return this.http.put('http://localhost:8080/orderitem/update', body, httpOptions);
  }
}

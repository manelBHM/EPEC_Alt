import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  getCustomers() {
    return this.http.get('http://localhost:8080/customer');
  }

  getCustomer(id: number) {
    return this.http.get('http://localhost:8080/customer/' + id);
  }

  createCustomerRegistration(customer) {
    let body = JSON.stringify(customer);
    return this.http.post('http://localhost:8080/customer', body, httpOptions);
  }

  deleteCustomer(customerId: number) {
    return this.http.delete('http://localhost:8080/customer/' + customerId);
  }

  saveCustomer(customer) {
    let body = JSON.stringify(customer);
    return this.http.put('http://localhost:8080/customer/update', body, httpOptions);
  }
}

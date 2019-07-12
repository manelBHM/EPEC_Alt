import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type':'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class StoreapiService {

  constructor(private http:HttpClient) { }

  getDvds(){
    return this.http.get('http://localhost:8098/api/v1/dvds');
  }

  getTotal(){
    return this.http.get('http://localhost:8098/api/v1/showtotal');
  }

  getPw(password:string){
    return this.http.get('http://localhost:8098/api/v1/getpw/' + password);
  }

  comparePwLog(login, password){
    return this.http.get('http://localhost:8098/api/v1/checklog/' + login + '&' + password);
  }

  getDvdById(id: number){
    return this.http.get('http://localhost:8098/api/v1/dvds/' + id);
  }

  createDvd(dvd){
    let body = JSON.stringify(dvd);
    return this.http.post('http://localhost:8098/api/v1/createdvd', body, httpOptions);
  }

  deleteDvd(id:number){
    return this.http.delete('http://localhost:8098/api/v1/deletedvd/' + id);
  }

  seeCart(){
    return this.http.get('http://localhost:8098/api/v1/seecart');
  }

  delCart(){
    return this.http.delete('http://localhost:8098/api/v1/clear');
  }

  addToCart(dvd){
    let body = JSON.stringify(dvd);
    return this.http.post('http://localhost:8098/api/v1/addtocart', body, httpOptions);
  }

  removeFromCart(dvd){
    let body = JSON.stringify(dvd);
    return this.http.post('http://localhost:8098/api/v1/removefromcart', body, httpOptions);
  }

  createCustomer(customer){
    let body = JSON.stringify(customer);
    return this.http.post('http://localhost:8098/api/v1/createcustomer', body, httpOptions);
  }

  getCustomers(){
    return this.http.get('http://localhost:8098/api/v1/showcust');
  }

  getCustomerById(id: number){
    return this.http.get('http://localhost:8098/api/v1/cust/' + id);
  }

  deleteCust(id:number){
    return this.http.delete('http://localhost:8098/api/v1/delcust/' + id);
  }
}



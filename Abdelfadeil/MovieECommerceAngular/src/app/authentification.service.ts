import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JwtHelper } from 'angular2-jwt';
// import { Http, Request, RequestOptions, RequestOptionsArgs, Response } from "@angular/http";
@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {

  private host: string = "http://localhost:8080";
  private jwtToken: string;
  private roles: Array<any> = [];

  constructor(private http: HttpClient) { }




  login(user) {
   return  this.http.post(this.host + "/login", user, { observe: 'response' });
  }


  saveToken(jwtToken) {
    this.jwtToken = jwtToken;
    localStorage.setItem('token', jwtToken);
    let jwtHelper = new JwtHelper();
    this.roles = jwtHelper.decodeToken(this.jwtToken).roles;
  }

  loadToken() {
    this.jwtToken = localStorage.getItem('token');
    return this.jwtToken;
  }

  register(user) {
    return this.http.post(this.host + "/users", user);
  }

  logout(){
    this.jwtToken= null;
    localStorage.removeItem('token');
    }

    isAdmin(){
    for(let r of this.roles){
    if(r.authority=='ADMIN') return true;
    }
    return false;
    }

}


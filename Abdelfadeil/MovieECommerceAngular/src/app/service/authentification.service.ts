import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JwtHelper } from 'angular2-jwt';
import "rxjs/Rx"
import { Router } from '@angular/router';
import { UserModule } from '../user/user.module';
// import { Http, Request, RequestOptions, RequestOptionsArgs, Response } from "@angular/http";
@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
   host: string = "http://localhost:8080";
   jwtToken: string;
   roles: Array<any> = [];

  constructor(private http: HttpClient, private router:Router) { }




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
    return this.http.post<UserModule>(this.host+ "/signup", user);
  }


  logout(){
    this.jwtToken= null;
    localStorage.removeItem('token');
    this.router.navigateByUrl('/login');
    }

    isAdmin(){
    for(let r of this.roles){
    if(r.authority=='ADMIN') return true;
    }
    return false;
    }

}


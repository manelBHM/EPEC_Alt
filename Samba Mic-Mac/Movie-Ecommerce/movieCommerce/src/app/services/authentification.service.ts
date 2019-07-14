import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { JwtHelper } from 'angular-jwt';
@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  host: string= "http://localhost:8080";
  jwtToken: any;
  roles: any;

  constructor(private http:HttpClient) { }



  register(user) {
    this.http.post(this.host+"/signup/", user);
   }

   login(user) {
   return  this.http.post(this.host+"/login", user, {observe: 'response'});
   }

   saveToken(jwtToken){
    this.jwtToken = jwtToken;
    localStorage.setItem('token', jwtToken);
    let jwtHelper = new JwtHelper();
    this.roles = jwtHelper.decodeToken(this.jwtToken).roles; 
   }

   loadToken() {
    this.jwtToken = localStorage.getItem('token');
    return this.jwtToken;
   }

   logout(){
    this.jwtToken = null;
    localStorage.removeItem('autorization');
  }
  isAdmin(){
  for(let r of this.roles){
   if(r.authority== "ADMIN") 
   return true;
  }
  return false;
  }
  
}

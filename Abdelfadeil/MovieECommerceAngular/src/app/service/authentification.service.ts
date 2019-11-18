import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JwtHelper } from 'angular2-jwt';
import "rxjs/Rx"
import { Router } from '@angular/router';
import { UserModule } from '../user/user.module';
import { User } from '../user.model';
// import { Http, Request, RequestOptions, RequestOptionsArgs, Response } from "@angular/http";
@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
   host: string = "http://localhost:8080";
   jwtToken: string;
   roles: Array<any> = [];
  username: String="";
  loginbtn: boolean =true;
  signupbtn: boolean =true;
  logoutbtn: boolean=false;
  public id:number;
  public user: User= new User( this.id , '', '', '', '', '', '');


  constructor(private http: HttpClient, private router:Router) { }




  login(user) {
   return  this.http.post(this.host + "/login", user, { observe: 'response' });
  }


  saveToken(jwtToken) {
    this.jwtToken = jwtToken;
    localStorage.setItem('token', jwtToken);
    let jwtHelper = new JwtHelper();
    this.roles = jwtHelper.decodeToken(this.jwtToken).roles;
    this.username = jwtHelper.decodeToken(this.jwtToken).sub;


  }

  loadToken() {
    this.jwtToken = localStorage.getItem('token');
    return this.jwtToken;
  }

  register(user) {
    return this.http.post<UserModule>(this.host+ "/signup", user);
  }

  chargerUserInfo(){
    if(this.jwtToken==null)
    this.jwtToken = this.loadToken();
    return this.http.get<User>(this.host+ "/user-info",  {headers:new HttpHeaders({'authorization':this.jwtToken})});
  }

  logout(){
    this.jwtToken= null;
    localStorage.removeItem('token');
    this.loginbtn =true;
    this.signupbtn =true;
    this.logoutbtn=false;
    this.router.navigateByUrl('/login');
    }

    isAdmin(){
    for(let r of this.roles){
    if(r.authority=='ADMIN') return true;
    }
    return false;
    }
  getUserInfo(){
    if(this.jwtToken==null)
    this.jwtToken = this.loadToken();
     return this.http.get<User>(this.host+"/user-info",  {headers:new HttpHeaders({'authorization':this.jwtToken})});
  }
}


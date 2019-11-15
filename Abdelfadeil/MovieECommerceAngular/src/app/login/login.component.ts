import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from '../service/authentification.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserModule } from '../user/user.module';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private mode = 0;
  constructor(private authService: AuthentificationService, private router: Router, private http:HttpClient) { }
  ngOnInit() {
    let token = this.authService.loadToken();
    if (token)
      this.router.navigateByUrl("/home");
  }
  onLogin(formData) {
    this.authService.login(formData)
      .subscribe(resp => {
        let jwtToken = resp.headers.get('authorization');
        this.authService.saveToken(jwtToken);
        this.authService.loginbtn=false;
        this.authService.logoutbtn=true;
        this.router.navigateByUrl('/home');

      },
      err => {
        // this.mode = 1;
        this.authService.logout();
        this.router.navigateByUrl('/login');
      })
     // this.getUserInfo(this.authService.username);

  }



}



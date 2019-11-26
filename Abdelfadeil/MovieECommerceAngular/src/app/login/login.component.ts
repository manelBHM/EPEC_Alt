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
  private user: UserModule = new UserModule();
  constructor(private authService: AuthentificationService, private router: Router, private http:HttpClient) { }


  ngOnInit() {
    let token = this.authService.loadToken();
    if (token !=null){
      this.router.navigateByUrl('/home');
    }else {
      this.authService.logout();
    }

  }
  onLogin(formData) {
    //this.user.password=formData.password;
   // this.user.username=formData.username;
   // this.user.email= formData.email;
    this.authService.login(formData)
      .subscribe(resp => {
        let jwtToken = resp.headers.get('authorization');
        this.authService.saveToken(jwtToken);
        this.authService.loginbtn=false;
        this.router.navigateByUrl('/home');

      },
      err => {
        // this.mode = 1;
        this.authService.logout();
       //this.router.navigateByUrl('/login');
      })


  }



}



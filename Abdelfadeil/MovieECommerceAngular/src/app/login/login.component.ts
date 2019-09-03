import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../authentification.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private mode = 0;
  constructor(private authService: AuthentificationService, private router: Router) { }
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
        this.router.navigateByUrl('/home');
      },
        err => {
          // this.mode = 1;
          this.router.navigateByUrl('/login');
        })
  }

  
}



import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from '../services/authentification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false
  mode;

  constructor(private router: Router,
    private autService: AuthentificationService) { }

    ngOnInit() {
      let token=this.autService.loadToken();
      if(token)
      this.router.navigateByUrl("/articles");
      }

  checkLogin() {
    // if (this.autService.authenticate(this.username, this.password)
    // ) {
    //   this.router.navigate([''])
    //   this.invalidLogin = false
    // } else
    //   this.invalidLogin = true
  }

  onLogin(formData) {
    this.autService.login(formData).subscribe( resp => {
    let jwtToken = resp.headers.get('authorization');
    this.autService.saveToken(jwtToken);
    this.router.navigateByUrl('/tasks');
   }, () => {
   this.mode= 1
   });
  }
}

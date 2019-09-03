import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../authentification.service';
import { Router } from '@angular/router';
import { UserModule } from '../user/user.module';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: UserModule;
  mode: number;
  errorMessage: any;

  constructor(private authService:AuthentificationService, private router: Router) { }

  ngOnInit() {
  }

  onRegister(user) {
    console.log(user)
    this.authService.register(user)
    .subscribe(data=>{
      this.mode=1;
      this.router.navigateByUrl('/login');
    },
      err=>{
     
      });
  }

  onLogin(formData) {
    this.authService.login(formData)
      .subscribe(resp => {
        let jwtToken = resp.headers.get('authorization');
        this.authService.saveToken(jwtToken);
        this.router.navigateByUrl('/');
      },
        err => {
          this.mode = 1;
        })
  }
}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  adminid: string;
  password: string;

  constructor() { }

  ngOnInit() {
  }

  LoginAdmin(){
    if(this.adminid == "SuperAdmin" && this.password == "izipassword"){
      console.log("Welcome!");
      window.location.replace("http://localhost:4200/admin/acceuil");
    } else {
      alert("Admin ID ou Mot de passe incorrect.");
    }
  }

}

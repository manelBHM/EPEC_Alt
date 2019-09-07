import { Component, OnInit, ViewChild, ElementRef  } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from './service/authentification.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{



  title = 'MovieECommerceAngular';
  mode: number;


constructor(public authService: AuthentificationService, private router:Router){}

   ngOnInit(): void {


   }
  onLogout(){
    this.authService.logout();
    this.router.navigateByUrl('/home');
    }







  }

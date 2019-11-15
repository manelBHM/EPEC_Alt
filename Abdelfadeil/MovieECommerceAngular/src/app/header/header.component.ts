import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from '../service/authentification.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  mode: number;
  public formSearch: boolean= true;
  public show: boolean =false;
 
  constructor(private authService: AuthentificationService,private router: Router) { }

  ngOnInit() {
  }
  /*
  onChercher() {
    this.router.navigateByUrl('/articles');
  }
this.authService.loginbtn
  searchForm() {
  // this.formSearch=!(this.formSearch);
  }
  */

  public showMenu() {
    this.show= !this.show;
  }

  onLogout(){
    this.authService.logout();
  }

  
}

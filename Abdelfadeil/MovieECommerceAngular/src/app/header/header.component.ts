import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../authentification.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  mode: number;
  formSearch: boolean= true;
  show: boolean =false;
  logout:boolean = false;

  constructor(private authService: AuthentificationService,private router: Router) { }

  ngOnInit() {
  }
  onChercher() {
    this.router.navigateByUrl('/articles');
  }

  searchForm() {
  // this.formSearch=!(this.formSearch);
  }

  showMenu() {
    this.show= !this.show;
  }

  onLogout(){
    this.logout = true;
    this.authService.logout();
  }
}

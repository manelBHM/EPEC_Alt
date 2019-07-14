import { Component } from '@angular/core';
import { AuthentificationService } from './authentification.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MovieECommerceAngular';
  mode: number;

constructor(public authService: AuthentificationService, private router:Router){}

  onLogout(){
    this.authService.logout();
    this.router.navigateByUrl("/");
    }
    
   public onLogin(formData){
      this.authService.login(formData)
      .subscribe(resp=>{
      let jwtToken=resp.headers.get('authorization');
      this.authService.saveToken(jwtToken);
      this.router.navigateByUrl("/");
      },
      err=>{
      this.mode=1;
      })
      }
      
    public  onRegister(){
        this.router.navigateByUrl("/register");
        }
    
  }
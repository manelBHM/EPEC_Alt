import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {StoreapiService} from '../../services/storeapi.service';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

clogin;
cpassword;
test;

username: string;
password:string;
validMessage: string = '';


validate;


  constructor(private route: ActivatedRoute, private router: Router, private storeApi: StoreapiService) {
    
   }

  ngOnInit() {
  }

LogInUser(){
  if(this.username=="admin" && this.password == "password"){
    this.router.navigate(['/admi-view'])
  }
}

LogCustomer(){
  
  if(this.validate){

  }
}

checkLogPw(clogin, cpassword){
  
  this.storeApi.comparePwLog(clogin, cpassword).subscribe(
    data => {
      this.validate = data;
    },err => console.error(err),
    () => console.log('password and log checked', this.validate, this.clogin, this.cpassword),
      )
      if(this.validate===true){
        this.router.navigate(['/list'])
      }
      else{
        this.validMessage = "INCORRECT LOGS"; 
      }

}


getPw(clogin){
  this.storeApi.getPw(clogin).subscribe(
    data => {
      this.test = data;
    },
    err => console.error(err),
    () => console.log('password checked : ', this.test)
  );
}


}

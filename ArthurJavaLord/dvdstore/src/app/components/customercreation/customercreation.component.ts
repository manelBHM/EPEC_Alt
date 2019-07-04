import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import {StoreapiService} from '../../services/storeapi.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-customercreation',
  templateUrl: './customercreation.component.html',
  styleUrls: ['./customercreation.component.css']
})
export class CustomercreationComponent implements OnInit {


  customerForm : FormGroup;
  validMessage: string = '';

  constructor(private storeapi: StoreapiService) { }

  ngOnInit() {
    this.customerForm = new FormGroup({
      name: new FormControl('', Validators.required),
      login: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  submitCustomerRegistration() {
    if(this.customerForm.valid){
      this.validMessage = "All good bro";
      this.storeapi.createCustomer(this.customerForm.value).subscribe(
        data => {
          this.customerForm.reset();
          return true;
        },     
          error => {
            return Observable.throw(error);
          }
      )
    } else{
      this.validMessage = "Please fill out that form bro"; 
    }
  }


}

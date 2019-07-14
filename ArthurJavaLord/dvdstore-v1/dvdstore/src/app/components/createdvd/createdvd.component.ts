import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import {StoreapiService} from '../../services/storeapi.service';

@Component({
  selector: 'app-createdvd',
  templateUrl: './createdvd.component.html',
  styleUrls: ['./createdvd.component.css']
})
export class CreatedvdComponent implements OnInit {

  dvdForm : FormGroup;
validMessage: string = '';
  
  constructor(private storeapi: StoreapiService) { }

  ngOnInit() {
    this.dvdForm = new FormGroup({
      title: new FormControl('', Validators.required),
      price: new FormControl('', Validators.required),
      country: new FormControl('', Validators.required),
      vo: new FormControl('', Validators.required),
      releaseDate: new FormControl('', Validators.required),
      photo: new FormControl('', Validators.required),
    });

  }

  submitDvdRegistration() {
    if(this.dvdForm.valid){
      this.validMessage = "All good bro";
      this.storeapi.createDvd(this.dvdForm.value).subscribe(
        data => {
          this.dvdForm.reset();
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

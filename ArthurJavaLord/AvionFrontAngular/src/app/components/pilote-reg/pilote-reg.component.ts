import { Component, OnInit } from '@angular/core';
import {PiloteService} from '../../services/pilote.service';
import {Observable} from 'rxjs';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';




@Component({
  selector: 'app-pilote-reg',
  templateUrl: './pilote-reg.component.html',
  styleUrls: ['./pilote-reg.component.css']
})
export class PiloteRegComponent implements OnInit {

  piloteform: FormGroup;
  validMessage: string = '';



  constructor(private piloteService:PiloteService) { }

  ngOnInit() {
    this.piloteform = new FormGroup({
      name: new FormControl('', Validators.required),
      site: new FormControl('', Validators.required)
    });
  }
  submitPiloteRegistration(){
    if(this.piloteform.valid){
      this.validMessage = "All good bro";
      this.piloteService.createPilote(this.piloteform.value).subscribe(
        data => {
          this.piloteform.reset();
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

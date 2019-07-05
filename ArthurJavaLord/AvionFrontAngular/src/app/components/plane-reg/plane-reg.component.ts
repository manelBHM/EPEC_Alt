import { Component, OnInit } from '@angular/core';
import {PlaneService} from '../../services/plane.service';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import {Observable} from 'rxjs';




@Component({
  selector: 'app-plane-reg',
  templateUrl: './plane-reg.component.html',
  styleUrls: ['./plane-reg.component.css']
})
export class PlaneRegComponent implements OnInit {
  models:string[] = [
    'A320',
    'A340',
    'B707',
    'Caravelle',
    'B747',
    'ATR42',
    'B727',
  ];

  makers:string[] = [
    'AIRBUS',
    'ATR',
    'BOEING',
    'CARAVELLE'
  ];

  planeform: FormGroup;
  validMessage: string = '';


  constructor(private planeService: PlaneService) { }

  ngOnInit() {

    this.planeform = new FormGroup({
      maker: new FormControl('', Validators.required),
      model: new FormControl('', Validators.required),
      capacity: new FormControl('', Validators.required),
      site: new FormControl('', Validators.required),
    });
  }

  submitPlaneRegistration() {
    if(this.planeform.valid){
      this.validMessage = "All good bro";
      this.planeService.createPlane(this.planeform.value).subscribe(
        data => {
          this.planeform.reset();
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

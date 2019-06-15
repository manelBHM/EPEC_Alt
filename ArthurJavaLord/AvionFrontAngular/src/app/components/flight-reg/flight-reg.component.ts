import { Component, OnInit } from '@angular/core';
import {FlightService} from '../../services/flight.service';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';





@Component({
  selector: 'app-flight-reg',
  templateUrl: './flight-reg.component.html',
  styleUrls: ['./flight-reg.component.css']
})
export class FlightRegComponent implements OnInit {

    flightForm: FormGroup;
    validMessage: string = '';
    pilotes:any[] = [];
    planes:any[] = [];
    url:string = ' http://localhost:4200/server/api/v1/pilotes';

  constructor(private flightService:FlightService, private http:HttpClient) { }

  ngOnInit() {

    this.http.get('http://localhost:4200/server/api/v1/pilotes').subscribe((response: any) => {      
      this.pilotes.push(...response)
      console.log("pilotes array", this.pilotes);  
    }),   
    
    this.http.get('http://localhost:4200/server/api/v1/planes').subscribe((response: any) => {      
      this.planes.push(...response)
      console.log("planes array", this.planes);  
    })   
  

    this.flightForm = new FormGroup({
      plane: new FormControl('', Validators.required),
      departureTime: new FormControl('', Validators.required),
      arrivingTime: new FormControl('', Validators.required),
      pilote: new FormControl('', Validators.required),
      departureSite: new FormControl('', Validators.required),
      arrivingSite: new FormControl('', Validators.required),
    });
  }

  submitFlightRegistration(){
    if(this.flightForm.valid){
      console.log(this.flightForm.value);
      this.validMessage = "All good bro";
      this.flightService.createFlight(this.flightForm.value).subscribe(
        data => {
          this.flightForm.reset();
          return true;
        }
      )
    } else{
      this.validMessage = "Please fill out that form bro"; 
    }
  }

}

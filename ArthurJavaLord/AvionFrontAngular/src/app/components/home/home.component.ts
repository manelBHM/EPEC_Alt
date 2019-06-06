import { Component, OnInit } from '@angular/core';
import {PiloteService} from '../../services/pilote.service';
import {FlightService} from '../../services/flight.service';
import {PlaneService} from '../../services/plane.service';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';







@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
    
  constructor() { }

  ngOnInit() {        
  }




}

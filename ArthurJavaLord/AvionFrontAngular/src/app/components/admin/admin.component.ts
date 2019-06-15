import { Component, OnInit } from '@angular/core';
import {PiloteService} from '../../services/pilote.service';
import {FlightService} from '../../services/flight.service';
import {PlaneService} from '../../services/plane.service';




@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public flights;
  public pilotes;
  public planes;

  constructor(private piloteService:PiloteService, private flightService:FlightService,
    private planeService:PlaneService) { }

  ngOnInit() {
    this.getPilotes();
    this.getPlanes();
    this.getFlights();
  }



  getPilotes(){
    this.piloteService.getPilotes().subscribe(
      data =>{this.pilotes = data},
      err => console.error(err),
      () => console.log('pilotes loaded')
      
      );
  }

  getPlanes(){
    this.planeService.getPlanes().subscribe(
      data =>{this.planes = data},
      err => console.error(err),
      () => console.log('planes loaded')
      
      );
  }

  getFlights(){
    this.flightService.getFlights().subscribe(
      data =>{this.flights = data},
      err => console.error(err),
      () => console.log('flight loaded', this.flights)
      
      );
  }

  deleteFlight(id:number){
    this.flightService.deleteFlight(id).subscribe(
      data => {
        console.log(data);
      },
    error => console.log(error));
    console.log('Clicked');
    window.location.reload();
  }

}

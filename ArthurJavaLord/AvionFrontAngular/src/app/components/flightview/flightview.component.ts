import { Component, OnInit } from '@angular/core';
import {FlightService} from '../../services/flight.service';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-flightview',
  templateUrl: './flightview.component.html',
  styleUrls: ['./flightview.component.css']
})
export class FlightviewComponent implements OnInit {

  public flightView;

  constructor(private route: ActivatedRoute, private flightService:FlightService ) { }

  ngOnInit() {
    this.getFlightView(this.route.snapshot.params.id);
  }

  getFlightView(id:number){
    this.flightService.getFlight(id).subscribe(
      data => {
        this.flightView = data;
      },
      err => console.error(err),
      () => console.log('flight loaded', this.flightView)
    );
    
  }

}

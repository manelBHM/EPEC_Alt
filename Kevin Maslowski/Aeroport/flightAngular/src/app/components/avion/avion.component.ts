import { Component, OnInit } from '@angular/core';
import { AvionService } from '../../services/avion.service';

@Component({
  selector: 'app-avion',
  templateUrl: './avion.component.html',
  styleUrls: ['./avion.component.css']
})
export class AvionComponent implements OnInit {
  public avions;

  constructor(private avionService: AvionService) { }

  ngOnInit() {
    this.getAvions();
  }

  getAvions(){
    this.avionService.getAvions().subscribe(
      data => { this.avions = data },
      err => console.error(err),
      () => console.log('avions reloaded')
    );
  }

}

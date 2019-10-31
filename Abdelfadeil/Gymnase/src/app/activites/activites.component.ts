import { Component, OnInit } from '@angular/core';
import {GymnasesService} from '../service/gymnases.service';

@Component({
  selector: 'app-activites',
  templateUrl: './activites.component.html',
  styleUrls: ['./activites.component.css']
})
export class ActivitesComponent implements OnInit {
  public gymnases;

  constructor(private gymnasesService:GymnasesService) { }

  ngOnInit() {
  this.getGymnases();
  }

  getGymnases(){
    this.gymnasesService.getGymnases().subscribe(data => {
      this.gymnases = data;
      console.log("ici this.gymnases  "+this.gymnases);
    }, error => {
      console.log(error);
    })
  }

}

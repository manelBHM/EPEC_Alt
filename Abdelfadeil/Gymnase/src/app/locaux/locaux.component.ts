import { Component, OnInit } from '@angular/core';
import * as jQuery from 'jquery';
import {GymnasesService} from '../service/gymnases.service';
window['$'] = jQuery;

declare var require: any;

@Component({
  selector: 'app-locaux',
  templateUrl: './locaux.component.html',
  styleUrls: ['./locaux.component.css']
})
export class LocauxComponent implements OnInit {
  gymnases;
  currentMotCle : String = '';
  currentPage: number = 0;
  page: number = 0;
  size: number = 1500;
  totalPages: number;
  pages: number[];



  constructor(private gymnasesService:GymnasesService) { }

  ngOnInit() {
    this.getGymnases();
    var $ = jQuery;
    require( 'datatables.net-bs4' )();
    require( 'datatables.net-buttons-bs4' )();

    $(document).ready(function() {
      $(".datatable").DataTable();
    });
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

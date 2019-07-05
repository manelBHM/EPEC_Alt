import { Component, OnInit } from '@angular/core';
import {StoreapiService} from '../../services/storeapi.service';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-dvdlist',
  templateUrl: './dvdlist.component.html',
  styleUrls: ['./dvdlist.component.css']
})
export class DvdlistComponent implements OnInit {

public dvds;
public dvdFromCart;

  constructor(private storeApi : StoreapiService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getDvds();
  }

  getDvds(){
    this.storeApi.getDvds().subscribe(
      data =>{this.dvds = data},
      err => console.error(err),
      () => console.log('Dvds chargées' + this.dvds)
    
      );
  }



}

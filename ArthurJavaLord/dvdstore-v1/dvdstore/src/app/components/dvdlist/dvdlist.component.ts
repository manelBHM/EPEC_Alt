import { Component, OnInit } from '@angular/core';
import {StoreapiService} from '../../services/storeapi.service';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-dvdlist',
  templateUrl: './dvdlist.component.html',
  styleUrls: ['./dvdlist.component.css']
})
export class DvdlistComponent implements OnInit {

public cust;
public dvds;
public dvdFromCart;
isHovering = false;
  constructor(private storeApi : StoreapiService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getDvds();
    this.getCust();
  }

  getDvds(){
    this.storeApi.getDvds().subscribe(
      data =>{this.dvds = data},
      err => console.error(err),
      () => console.log('Dvds chargées' + this.dvds)
    
      );
  }

  getCust(){
    this.storeApi.getCustomers().subscribe(
      data =>{this.cust = data},
      err => console.error(err),
      () => console.log('Cust chargées' + this.cust)
          );
  }


  mouseHovering() {
      this.isHovering = true;
  }
  mouseLeaving() {
      this.isHovering = false;
  }

}

import { Component, OnInit } from '@angular/core';
import {StoreapiService} from '../../services/storeapi.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {
  
  public dvds;
  public dvdFromCart;

  constructor(private storeApi : StoreapiService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getDvds();
    this.getDvdFromCart();
    }


  getDvds(){
    this.storeApi.getDvds().subscribe(
      data =>{this.dvds = data},
      err => console.error(err),
      () => console.log('Dvds chargées' + this.dvds)
    
      );
  }
  getDvdFromCart(){
    this.storeApi.seeCart().subscribe(
      data =>{this.dvdFromCart = data},
      err => console.error(err),
      () => console.log('Dvds chargées' + this.dvdFromCart)
     );
  }
}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {StoreapiService} from '../../services/storeapi.service';
import {Router} from "@angular/router"

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

total;

  constructor(private storeApi: StoreapiService) { }

  ngOnInit() {
    this.showTotal();
  }

  showTotal(){
    
    this.storeApi.getTotal().subscribe(
      data => {
        this.total = data;
      },
      err => console.error(err),
      () => console.log('definitions loaded', this.total)
    );
  
  }

}

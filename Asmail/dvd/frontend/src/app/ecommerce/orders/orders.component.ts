import { Component, OnInit } from '@angular/core';
import { EcommerceServiceService } from 'src/app/services/ecommerce-service.service';
import { ProductOrders } from 'src/app/entities/ProductOrders';
import {Subscription} from "rxjs/internal/Subscription";
import { Router } from '@angular/router';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  orders: ProductOrders;
  total: number;
  paid: boolean;
  sub: Subscription;

  constructor(private ecommerceService: EcommerceServiceService, private router: Router) {
      this.orders = this.ecommerceService.ProductOrders;
  }

  ngOnInit() {
      this.paid = false;
      this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
          this.orders = this.ecommerceService.ProductOrders;
      });
      this.loadTotal();
  }

  pay() {
      this.paid = true;
      this.ecommerceService.saveOrder(this.orders).subscribe();
  }

  loadTotal() {
      this.sub = this.ecommerceService.TotalChanged.subscribe(() => {
          this.total = this.ecommerceService.Total;
      });
}
goToHome(){
    this.router.navigate(['/']);
  }
}

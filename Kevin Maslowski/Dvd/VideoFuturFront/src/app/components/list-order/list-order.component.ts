import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/orderz.service';

@Component({
  selector: 'app-list-order',
  templateUrl: './list-order.component.html',
  styleUrls: ['./list-order.component.css']
})
export class ListOrderComponent implements OnInit {

  private orders;

  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.getOrders();
  }

  getOrders() {
    this.orderService.getOrders().subscribe(
      data => { this.orders = data },
      err => console.error(err),
      () => console.log('orders loaded')
    );
  }

  deleteOrder(id: number) {
    this.orderService.deleteOrder(id).subscribe(
      data => {
        console.log(data);
      },
      err => console.error(err)
    );
    console.log('order deleted'),
    window.location.reload();
  }

}

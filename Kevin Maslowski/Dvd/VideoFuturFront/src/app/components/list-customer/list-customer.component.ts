import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  public customers;

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.getCustomers();
  }

  getCustomers() {
    this.customerService.getCustomers().subscribe(
      data => { this.customers = data },
      err => console.error(err),
      () => console.log('customers loaded')
    );
  }

  deleteCustomer(id: number) {
    this.customerService.deleteCustomer(id).subscribe(
      data => {
        console.log(data);
      },
      err => console.error(err)
    );
    console.log('customer deleted'),
    window.location.reload();
  }

}

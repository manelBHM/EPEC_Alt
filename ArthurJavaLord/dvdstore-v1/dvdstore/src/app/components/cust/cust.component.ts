import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {StoreapiService} from '../../services/storeapi.service';
import {Router} from "@angular/router"

@Component({
  selector: 'app-cust',
  templateUrl: './cust.component.html',
  styleUrls: ['./cust.component.css']
})
export class CustComponent implements OnInit {
cust;
  constructor(private route: ActivatedRoute, private storeApi : StoreapiService, private router: Router) { }

  ngOnInit() {
    this.getCust(this.route.snapshot.params.id);

  }

  getCust(id:number){
    this.storeApi.getCustomerById(id).subscribe(
      data => {
        this.cust = data;
      },
      err => console.error(err),
      () => console.log('cust loaded', this.cust)
    );
  }

  deleteCust(id: number){
    if ( confirm( "Please Confirm" ) ){
    this.storeApi.deleteCust(id).subscribe(
      data => {
        console.log(data);
      },
    error => console.log(error));
    console.log('Clicked');
    }
    this.router.navigate(['/admin-view'])
    
}

}

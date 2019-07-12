import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {StoreapiService} from '../../services/storeapi.service';
import {Router} from "@angular/router"



@Component({
  selector: 'app-dvdspec',
  templateUrl: './dvdspec.component.html',
  styleUrls: ['./dvdspec.component.css']
})
export class DvdspecComponent implements OnInit {

  public dvd

  constructor(private route: ActivatedRoute, private storeApi : StoreapiService, private router: Router) { }

  ngOnInit() {
    this.getDefView(this.route.snapshot.params.id);
  }

  getDefView(id:number){
    this.storeApi.getDvdById(id).subscribe(
      data => {
        this.dvd = data;
      },
      err => console.error(err),
      () => console.log('definitions loaded', this.dvd)
    );
  }

  deleteDvd(id: number){
    if ( confirm( "Please Confirm" ) ){
    this.storeApi.deleteDvd(id).subscribe(
      data => {
        console.log(data);
      },
    error => console.log(error));
    console.log('Clicked');
    }
    this.router.navigate(['/admin_view'])
    window.location.reload();
    
}

  addToCart(){
    this.storeApi.addToCart(this.dvd).subscribe();
    console.log('clicked' + this.dvd);
  }

  removeFromCart(){
    this.storeApi.removeFromCart(this.dvd).subscribe();
    console.log('clicked' + this.dvd);
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { DvdService } from 'src/app/services/dvd.service';
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
  public dvds;

  constructor(private dvdService: DvdService) { }

  ngOnInit() {
    this.getDvds();
  }

  getDvds() {
    this.dvdService.getDvds().subscribe(
      data => { this.dvds = data },
      err => console.error(err),
      () => console.log('dvds loaded')
    );
  }


}

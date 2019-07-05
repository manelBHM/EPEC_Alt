import { Component, OnInit } from '@angular/core';
import { DvdService } from 'src/app/services/dvd.service';

@Component({
  selector: 'app-list-films',
  templateUrl: './list-films.component.html',
  styleUrls: ['./list-films.component.css']
})
export class ListFilmsComponent implements OnInit {

  public dvds;

  constructor(private dvdService: DvdService) { }

  ngOnInit() {
    this.getDvds();
  }

  getDvds() {
    this.dvdService.getDvds().subscribe(
      data => { this.dvds = data },
      err => console.error(err),
      () => console.log('dvd loaded')
    );
  }

  deleteDvd(id: number) {
    this.dvdService.deleteDvd(id).subscribe(
      data => {
        console.log(data);
      },
      err => console.error(err)
    );
    console.log('dvd deleted'),
    window.location.reload();
  }

}

import { Component, OnInit } from '@angular/core';
import { VolService } from '../../services/vol.service';

@Component({
  selector: 'app-vol',
  templateUrl: './vol.component.html',
  styleUrls: ['./vol.component.css']
})
export class VolComponent implements OnInit {
  public vols;

  constructor(private volService: VolService) { }

  ngOnInit() {
    this.getVols();
  }

  getVols(){
    this.volService.getVols().subscribe(
      data => { this.vols = data },
      err => console.error(err),
      () => console.log('vols loaded')
    );
  }
}

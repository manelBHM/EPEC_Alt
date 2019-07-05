import { Component, OnInit } from '@angular/core';
import {PiloteService} from '../../services/pilote.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-view-registration',
  templateUrl: './view-registration.component.html',
  styleUrls: ['./view-registration.component.css']
})
export class ViewRegistrationComponent implements OnInit {

  public piloteReg;
  constructor(private piloteService: PiloteService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getPiloteReg(this.route.snapshot.params.id);
  }

  getPiloteReg(id:number){
    this.piloteService.getPilote(id).subscribe(
      data => {
        this.piloteReg = data;
      },
      err => console.error(err),
      () => console.log('pilotes loaded')
    );
  }
}

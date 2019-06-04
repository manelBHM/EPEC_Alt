import { Component, OnInit, Input } from '@angular/core';
import { PiloteService } from '../../services/pilote.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-pilote',
  templateUrl: './pilote.component.html',
  styleUrls: ['./pilote.component.css']
})
export class PiloteComponent implements OnInit {
  public pilotes;

  constructor(private piloteService: PiloteService) { }

  ngOnInit() {
    this.getPilotes();
  }

  getPilotes(){
    this.piloteService.getPilotes().subscribe(
      data => { this.pilotes = data },
      err => console.error(err),
      () => console.log('pilotes loaded')
    );
  }

  deletePilote(id: number) {
    this.piloteService.deletePilote(id).subscribe(
      data => {
        console.log(data);
      },
      err => console.error(err));
      console.log('pilotes loaded'),
      window.location.reload();
  }


}

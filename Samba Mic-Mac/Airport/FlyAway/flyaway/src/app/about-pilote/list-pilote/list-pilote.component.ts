import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { Pilote } from '../../pilote';
import { HttpClientService } from '../../service/httpclient.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-list-pilote',
  templateUrl: './list-pilote.component.html',
  styleUrls: ['./list-pilote.component.css']
})
export class ListPiloteComponent implements OnInit {

  constructor(private piloteService : HttpClientService, private router: Router) {

  }

  pilotes$: Observable<Pilote[]>

  ngOnInit() {
    this.reloadData();
  }

  deletePilote(id: number){
    this.piloteService.deletePilote(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log('ERROR' + error));
  }

  reloadData(){
    this.pilotes$ = this.piloteService.getPilote();
  }


  editPilote(pilote: Pilote): void {
    localStorage.removeItem("editPiloteId");
    console.log( pilote);
    localStorage.setItem("editPiloteId", pilote.id.toString());
    this.router.navigate(['edit-pilote']);
  };

  addPilote(id: number){
    this.router.navigate(['add-pilote'])
 }
   
}

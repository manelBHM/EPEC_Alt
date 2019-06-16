import { Component, OnInit } from '@angular/core';
import { PilotesService } from '../services/pilotes.service';
import { PiloteModel } from 'src/model/Pilote.Model';

@Component({
  selector: 'app-pilotes',
  templateUrl: './pilotes.component.html',
  styleUrls: ['./pilotes.component.css']
})
export class PilotesComponent implements OnInit {

  currentPage:number=0;
  page:number=0;
  size:number=5;
  totalPages: number;
  pages: number[];
  currentMotCle: String="";

  pilote:PiloteModel;
  pilotes:PiloteModel;

  constructor(private pilotesService: PilotesService) { }

  ngOnInit() {

    this.pilotesService.getPilotes().subscribe(data => {
      this.pilotes= data;
      console.log(this.pilotes)
    },error => {});
  }
  title = 'Liste des Pilotes';

onChercher(form:any){
  console.log(form.motCle)
    this.currentMotCle=form.motCle;
  this.pilotesService.getPilotes().subscribe(data => {
    this.pilotes= data;
  },error => {
    console.log(error);
  });
}

onPilotesPage(i){
  
}

onDelete(p){
  let conf=confirm("Êtes vous sûr de vouloir supprimer?");
   if(conf){
     this.pilotesService.delete(p._links.self.href).subscribe(data => {
      console.log(data);
      this.onChercher('');
     }, error => {
       console.log(error);
     });
   }
}
}

import { Component, OnInit } from '@angular/core';
import { PilotesService } from '../services/pilotes.service';
import { PiloteModel } from 'src/model/Pilote.Model';
import { Router } from '@angular/router';

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

  constructor(private pilotesService: PilotesService, private router:Router) { }

  ngOnInit() {

    this.pilotesService.getPilotes().subscribe(data => {
      this.pilotes= data;
    },error => {});
  }
  title = 'Liste des Pilotes';

onChercher(form:any){
  this.currentMotCle=form.motCle;
  this.pilotesService.getPilotesByKeyNom(this.currentMotCle, this.currentPage, this.size).subscribe(data => {
    this.totalPages=data["page"].totalPages;
    this.pages= new Array<number>(this.totalPages);
    this.pilotes= data;
  },error => {});
}

onPilotesPage(i){
  this.currentPage=i;
  this.onChercher(this.currentMotCle);
}

onDelete(p){
  let conf=confirm("Êtes vous sûr de vouloir supprimer?");
   if(conf){
     this.pilotesService.delete(p._links.self.href).subscribe(data => {
      this.onChercher('');
     }, error => {
       console.log(error);
     });
   }
}

onUpdate(p){
  let url = p._links.self.href;
  this.router.navigateByUrl("/editer-pilote/"+btoa(url));
}

}

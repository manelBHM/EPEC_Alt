import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PilotesService } from '../services/pilotes.service';

@Component({
  selector: 'app-editer-pilote',
  templateUrl: './editer-pilote.component.html',
  styleUrls: ['./editer-pilote.component.css']
})
export class EditerPiloteComponent implements OnInit {

  private currentPilote;
  url: any;
  constructor(private router:Router, private activatedRoute:ActivatedRoute, private pilotesService:PilotesService) { }

  ngOnInit() {
   this.url= atob(this.activatedRoute.snapshot.params.id);
    this.pilotesService.getPilote(this.url).subscribe(data => {
      this.currentPilote=data;
    }, err=>{
      console.log(err);
    })  }

    onUpdatePilote(value:any){
      this.pilotesService.editerPilote(this.url, value).subscribe(data => {
          alert("mis à jour effectuée avec succès");
          this.router.navigateByUrl("/pilotes");
      }, err=>{
        console.log(err);
      })
    }


}

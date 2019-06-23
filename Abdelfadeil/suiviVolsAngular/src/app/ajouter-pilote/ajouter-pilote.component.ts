import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PiloteModel } from 'src/model/Pilote.Model';
import { PilotesService } from '../services/pilotes.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ajouter-pilote',
  templateUrl: './ajouter-pilote.component.html',
  styleUrls: ['./ajouter-pilote.component.css']
})
export class AjouterPiloteComponent implements OnInit {

  pilote: PiloteModel;
  constructor(private piloteService: PilotesService,private router:Router) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    console.log(form.value);
    // this.pilote.nom = form.value.nom;
    // this.pilote.vol_id = form.value.vol_id;
    // this.pilote.site = form.value.site;
    this.piloteService.Save(form.value).subscribe(data =>{
      this.router.navigateByUrl('/pilotes');
      console.log('ajout réussir '+data);
    }, error =>{
      console.log(error);

    })


}
}

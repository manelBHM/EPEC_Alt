import { Component, OnInit } from '@angular/core';
import { PiloteService } from 'src/app/services/pilote.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-ajoutpilote',
  templateUrl: './ajoutpilote.component.html',
  styleUrls: ['./ajoutpilote.component.css']
})
export class AjoutpiloteComponent implements OnInit {
  
  piloteform: FormGroup;
  validMessage: string = "";

  constructor(private piloteService: PiloteService) { }

  ngOnInit() {
    this.piloteform = new FormGroup({
      nom: new FormControl('', Validators.required),
      site: new FormControl('', Validators.required),
    });
  }

  submitRegistration() {
    if (this.piloteform.valid) {
      this.validMessage = "Votre pilote a bien été ajouter à la base de données. Merci ! :-)";
      this.piloteService.createPiloteRegistration(this.piloteform.value).subscribe(
        data => {
          this.piloteform.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      )
    } else {
      this.validMessage = "S'il vous plait, complétez le formulaire avant de l'envoyer."
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { AvionService } from 'src/app/services/avion.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-ajoutavion',
  templateUrl: './ajoutavion.component.html',
  styleUrls: ['./ajoutavion.component.css']
})
export class AjoutavionComponent implements OnInit {
  construct: string[] = [
    'AIRBUS',
    'BOEING',
    'CARAVELLE',
    'ATR'
  ];

  models: string[] = [
    'A380',
    'A320',
    'A340',
    'B707',
    'B747',
    'B797',
    'Caravelle',
    'ATR42'
  ];

  capacity: number[] = [
    50, 100, 150, 200, 250,
    300, 350, 400, 450
  ];
  avionform: FormGroup;
  validMessage: string = "";

  constructor(private avionService: AvionService) { }

  ngOnInit() {
    this.avionform = new FormGroup({
      constructeur: new FormControl('', Validators.required),
      model:new FormControl('', Validators.required),
      capacite: new FormControl('', Validators.required),
      site: new FormControl('', Validators.required)
    });
  }

  submitRegistration() {
    if (this.avionform.valid) {
      this.validMessage = "Votre avion a bien été ajouter à la base de données. Merci ! :-)";
      this.avionService.createAvionRegistration(this.avionform.value).subscribe(
        data => {
          this.avionform.reset();
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

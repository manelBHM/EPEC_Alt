import { Component, OnInit } from '@angular/core';
import { PiloteService } from 'src/app/services/pilote.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view-pilote',
  templateUrl: './view-pilote.component.html',
  styleUrls: ['./view-pilote.component.css']
})
export class ViewPiloteComponent implements OnInit {

  public piloteReg;
  saveformpilote: FormGroup;
  validMessage: string = "";

  constructor(private piloteService: PiloteService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getPiloteReg(this.route.snapshot.params.id);
    this.saveformpilote = new FormGroup({
      id: new FormControl('', Validators.required),
      nom: new FormControl('', Validators.required),
      site: new FormControl('', Validators.required),
    });
  }

  getPiloteReg(id:number) {
    this.piloteService.getPilote(id).subscribe(
      data => {
        this.piloteReg = data;
      },
      err => console.error(err),
      () => console.log('pilotes loaded')
    );
  }

  gotoList() {
    window.location.replace("http://localhost:4200/admin/pilotes");
  }

  savePilote() {
    if (this.saveformpilote.valid) {
      this.gotoList();
      this.validMessage = "Votre pilote a bien été modifié. Merci ! :-)";
      this.piloteService.savePilote(this.saveformpilote.value).subscribe(
        data => {
          this.saveformpilote.reset();
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

import { Component, OnInit } from '@angular/core';
import { AvionService } from 'src/app/services/avion.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view-avion',
  templateUrl: './view-avion.component.html',
  styleUrls: ['./view-avion.component.css']
})
export class ViewAvionComponent implements OnInit {

  public avionReg;
  saveformavion: FormGroup;
  validMessage: string = "";

  constructor(private avionService: AvionService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getAvionReg(this.route.snapshot.params.id);
    this.saveformavion = new FormGroup({
      id: new FormControl('', Validators.required),
      constructeur: new FormControl('', Validators.required),
      model: new FormControl('', Validators.required),
      capacite: new FormControl('', Validators.required),
      site: new FormControl('', Validators.required)
    })
  }

  getAvionReg(id:number) {
    this.avionService.getAvion(id).subscribe(
      data => {
        this.avionReg = data;
      },
      err => console.error(err),
      () => console.log('avions loaded')
    );
  }

  gotoList() {
    window.location.replace("http://localhost:4200/admin/avions");
  }

  saveAvion() {
    if(this.saveformavion.valid) {
      this.gotoList();
      this.validMessage = "Votre avion a bien été modifié. Merci ! :-)";
      this.avionService.saveAvion(this.saveformavion.value).subscribe(
        date => {
          this.saveformavion.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      )
    } else {
      this.validMessage = "S'il vous plait, compétez le formulaire avant de l'envoyer."
    }
  }

}

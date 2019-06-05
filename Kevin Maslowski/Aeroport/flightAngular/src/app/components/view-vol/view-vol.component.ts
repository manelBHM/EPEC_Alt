import { Component, OnInit } from '@angular/core';
import { VolService } from 'src/app/services/vol.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view-vol',
  templateUrl: './view-vol.component.html',
  styleUrls: ['./view-vol.component.css']
})
export class ViewVolComponent implements OnInit {

  public volReg;
  saveformvol: FormGroup;
  validMessage: string = "";

  constructor(private volService: VolService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getVolReg(this.route.snapshot.params.id);
    this.saveformvol = new FormGroup({
      id: new FormControl('', Validators.required),
      avion: new FormControl('', Validators.required),
      pilote: new FormControl('', Validators.required),
      siteArrivee: new FormControl('', Validators.required),
      siteDepart: new FormControl('', Validators.required),
      heureArrivee: new FormControl('', Validators.required),
      heureDepart: new FormControl('', Validators.required)
    });
  }

  getVolReg(id:string) {
    this.volService.getVol(id).subscribe(
      data => {
        this.volReg = data;
      },
      err => console.error(err),
      () => console.log('vols loaded')
    );
  }

  gotoList() {
    window.location.replace("http://localhost:4200/admin/vols");
  }

  saveVol() {
    if (this.saveformvol.valid) {
      this.gotoList();
      this.validMessage = "Votre vol a bien été modifié. Merci ! :-)";
      this.volService.saveVol(this.saveformvol.value).subscribe(
        data => {
          this.saveformvol.reset();
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

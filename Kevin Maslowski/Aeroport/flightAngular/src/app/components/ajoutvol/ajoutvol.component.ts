import { Component, OnInit } from '@angular/core';
import { VolService } from 'src/app/services/vol.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Rx';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-ajoutvol',
  templateUrl: './ajoutvol.component.html',
  styleUrls: ['./ajoutvol.component.css']
})
export class AjoutvolComponent implements OnInit {
  avi: any[] = [];
  pilotes: any[] = [];
  volform: FormGroup;
  validMessage: string = "";

  constructor(private volService: VolService, private http: HttpClient) { }

  ngOnInit() {

    this.http.get('http://localhost:4200/server/avions').subscribe((res:any) => {
      this.avi.push(...res)
      console.log('Planes loaded', this.avi)
    }),

    this.http.get('http://localhost:4200/server/pilotes').subscribe((response:any) => {
      this.pilotes.push(...response)
      console.log('Pilotes loaded', this.avi)
    }),

    this.volform = new FormGroup({
      id: new FormControl('', Validators.required),
      avion: new FormControl('', Validators.required),
      pilote: new FormControl('', Validators.required),
      siteArrivee: new FormControl('', Validators.required),
      siteDepart: new FormControl('', Validators.required),
      heureArrivee: new FormControl('', Validators.required),
      heureDepart: new FormControl('', Validators.required)
    });

  }


  submitRegistration() {
    if (this.volform.valid) {
      this.validMessage = "Votre vol a bien été ajouter à la base de données. Merci ! :-)";
      this.volService.createVolRegistration(this.volform.value).subscribe(
        data => {
          this.volform.reset();
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

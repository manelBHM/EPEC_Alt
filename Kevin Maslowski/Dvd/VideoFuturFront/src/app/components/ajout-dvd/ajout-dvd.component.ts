import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { DvdService } from 'src/app/services/dvd.service';
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-ajout-dvd',
  templateUrl: './ajout-dvd.component.html',
  styleUrls: ['./ajout-dvd.component.css']
})
export class AjoutDvdComponent implements OnInit {

  dvdform: FormGroup;
  validMessage: String = "";

  constructor(private dvdService: DvdService) { }

  ngOnInit() {
    this.dvdform = new FormGroup({
      price: new FormControl('', Validators.required),
      category: new FormControl('', Validators.required),
      name: new FormControl('', Validators.required),
      photo: new FormControl('', Validators.required),
      view: new FormControl('', Validators.required),
      stock: new FormControl('', Validators.required)
    });
  }

  submitRegistration() {
    if (this.dvdform.valid) {
      this.validMessage = "Votre dvd a bien été ajouté à la base de données. Merci ! :-)";
      this.dvdService.createDvdRegistration(this.dvdform.value).subscribe(
        data => {
          this.dvdform.reset();
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

import { Component, OnInit } from '@angular/core';
import { VolService } from '../../services/vol.service'
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Rx';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-pilote-page',
  templateUrl: './pilote-page.component.html',
  styleUrls: ['./pilote-page.component.css']
})
export class PilotePageComponent implements OnInit {

  public volByPilote;
  findbypiloteform: FormGroup;
  validMessage: string = "";
  showTable: boolean = false;

  constructor(private volService: VolService) { }

  ngOnInit() {
    this.findbypiloteform = new FormGroup({
      pilote: new FormControl('', Validators.required)
    });
  }

  // getVolByPilote(pilote: number) {
  //   console.log(pilote);
  //   this.volService.getVolsByPilote(pilote).subscribe(
  //     data => {
  //       this.volByPilote = data;
  //     },
  //     err => console.error(err),
  //     () => console.log("FlightByPilote find")
  //   );
  // }

   getVolByPilote(){
    if (this.findbypiloteform.valid) {
      this.validMessage = "Voici vos vols.";
      console.log(this.findbypiloteform);
      this.volService.getVolsByPilote(this.findbypiloteform.value.pilote).subscribe(
        data => {
          this.volByPilote = data;
          this.findbypiloteform.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      )
    } else {
      // this.validMessage = "Cet ID de pilote n'existe pas. Veuillez rééssayer."
    }
  }

  toggleTable(): void {
    this.showTable = !this.showTable;
  }

}

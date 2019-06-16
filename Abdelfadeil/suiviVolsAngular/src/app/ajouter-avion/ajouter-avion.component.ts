import { Component, OnInit } from '@angular/core';
import { AvionsService } from '../services/avions.service';
import { AvionModel } from 'src/model/avion.model';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ajouter-avion',
  templateUrl: './ajouter-avion.component.html',
  styleUrls: ['./ajouter-avion.component.css']
})
export class AjouterAvionComponent implements OnInit {
 avion: AvionModel;
  constructor(private avionService: AvionsService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
  this.avionService.Save(form.value).subscribe(data => {
    console.log('ajout réussir '+data);
    this.router.navigateByUrl("/avions");
  }, error => {
    console.log(error)
  })
  }

}

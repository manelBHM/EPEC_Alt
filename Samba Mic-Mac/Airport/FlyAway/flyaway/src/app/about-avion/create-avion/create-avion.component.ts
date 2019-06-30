import { Component, OnInit } from '@angular/core';
import { AvionService } from '../../service/avion.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'; 
import { Avion } from '../../avion';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-create-avion',
  templateUrl: './create-avion.component.html',
  styleUrls: ['./create-avion.component.css']
})
export class CreateAvionComponent implements OnInit {

  constructor(private avionService: AvionService, private formBuilder: FormBuilder, private router: Router) { }

  avion : Avion = new Avion();
  avions: Observable<Avion>;
  addForm: FormGroup;

  ngOnInit() {
     this.addForm = this.formBuilder.group({
       id: [],
       constructeur: ['', Validators.required],
       modele: ['', Validators.required],
       capacite: ['', Validators.required],
       site: ['', Validators.required]
     })
  }

  onSubmit(){
    this.avionService.createAvion(this.addForm.value).subscribe(
      data => {
        this.router.navigate(['list-avion']);
      }
    )
  }

}

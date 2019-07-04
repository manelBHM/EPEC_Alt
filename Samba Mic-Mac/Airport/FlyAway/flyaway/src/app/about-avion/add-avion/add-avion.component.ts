import { Component, OnInit } from '@angular/core';
import { AvionService } from '../../service/avion.service';
import { Avion } from '../../avion';
import { Observable } from 'rxjs';
import { FormGroup, FormsModule, FormBuilder, Validators, FormControl, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-avion',
  templateUrl: './add-avion.component.html',
  styleUrls: ['./add-avion.component.css']
})
export class AddAvionComponent implements OnInit {

  constructor(private router: Router,private  formBuilder: FormBuilder, private avionService: AvionService) { }
   
  avion: Avion = new Avion();
  avions: Observable<Avion>

  addForm: FormGroup;
  submitted: boolean = false;

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

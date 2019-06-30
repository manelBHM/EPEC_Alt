import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, NgForm, Validators} from '@angular/forms';
import { Avion } from '../../avion';
import { AvionService } from '../../service/avion.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';


@Component({
  selector: 'app-edit-avion',
  templateUrl: './edit-avion.component.html',
  styleUrls: ['./edit-avion.component.css']
})

export class EditAvionComponent implements OnInit {

  constructor(private avionService: AvionService, private router: Router, private formBuilder: FormBuilder) { }
   avion : Avion;
   public editForm: FormGroup;
   load: boolean = false;

  ngOnInit() {
    let editId = localStorage.getItem("editAvionId");
    if(!editId){
      alert("Invalid action.")
      this.router.navigate(['list-avion']);
      return;
    }
    this.editForm = this.formBuilder.group({
       id: [],
       constructeur: ['', Validators.required],
       modele:   ['', Validators.required],
       capacite: ['', Validators.required],
       site:     ['', Validators.required]
    });

    this.avionService.getAvionById( + editId).subscribe(
      data => {
        this.editForm.setValue(data);
        console.log(!this.editForm);   
      });
  }

  onSubmit(){
   //return console.log('check', this.editForm.value);
    
    this.avionService.updateAvion(this.editForm.value).
    pipe(first()).subscribe(
      data => {
      this.router.navigate(['list-avion']);
        console.log(data);
      },
      error => {
        alert('Error' + error);
      })
    }
}

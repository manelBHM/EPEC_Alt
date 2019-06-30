import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators, FormControl, ReactiveFormsModule } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Vol } from '../../vol';
import { VolService } from '../../service/vol.service';
import { Avion } from 'src/app/avion';
import { Pilote } from 'src/app/pilote';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-create-vol',
  templateUrl: './create-vol.component.html',
  styleUrls: ['./create-vol.component.css']
})
export class CreateVolComponent implements OnInit {

  constructor(private router: Router, private volService: VolService, private formBuilder: FormBuilder) { }

  avions: Observable<Avion>;
  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      avion: ['', Validators.required],
      pilote: ['', Validators.required],
      siteArrive: ['', Validators.required],
      siteDepart: ['', Validators.required],
      heureArrive: ['', Validators.required],
      heureDepart: ['', Validators.required],
  });
  }
  onSubmit(){
    this.volService.createVol(this.addForm.value).subscribe(
      data => {
        this.router.navigate(['list-avion']);
      }
    )
  }
}

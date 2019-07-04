import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../../service/httpclient.service';
import { Pilote } from '../../pilote';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators, FormsModule, FormControl, ReactiveFormsModule } from '@angular/forms'
import { Router } from '@angular/router'; 


@Component({
  selector: 'app-add-pilote',
  templateUrl: './add-pilote.component.html',
  styleUrls: ['./add-pilote.component.css']
})
export class AddPiloteComponent implements OnInit {


  constructor(private piloteService: HttpClientService, private router: Router , private formBuider: FormBuilder) { }

   pilote: Pilote = new Pilote();
   pilotes: Observable<Object>;

   addForm: FormGroup;
   submitted = false;

  ngOnInit() {
    this.addForm = this.formBuider.group({
      id: [],
      name: ['', Validators.required],
      site: ['', Validators.required]
    });
  }

    onSubmit() {
      this.piloteService.createPilote(this.addForm.value)
      .subscribe( data => {
          this.router.navigate(['list-pilote'])
      })
    }
  }


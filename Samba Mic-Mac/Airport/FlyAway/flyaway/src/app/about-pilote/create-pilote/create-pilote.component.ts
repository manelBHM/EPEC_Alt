import { Component, OnInit, Input } from '@angular/core';
import { HttpClientService } from '../../service/httpclient.service';
import { Pilote } from '../../pilote';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';;
import { FormBuilder, FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-create-pilote',
  templateUrl: './create-pilote.component.html',
  styleUrls: ['./create-pilote.component.css']
})
export class CreatePiloteComponent implements OnInit {

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

    /* this.route.paramMap.subscribe( param => {
      const piloteId = + param.get('id');
      if(piloteId){
        this.piloteService.getPilote(piloteId);
      }
    }); 
  }*/

 /*  getPilote(id: number){
    this.piloteService.getPilote(id).subscribe(
      (pilote: Pilote) => editPilote(pilote),
      error => console.log(error)
      );
  }
 */

  /* newCustomer(): void {
    this.submitted = false;
    this.pilote = new Pilote();
  }
 
  save() {
    this.piloteService.createPilote(this.pilote)
      .subscribe(data => console.log(data), error => console.log(error));
    this.pilote = new Pilote();
  }
 
  onSubmit() {
    this.submitted = true;
    this.save();
  } 
 */



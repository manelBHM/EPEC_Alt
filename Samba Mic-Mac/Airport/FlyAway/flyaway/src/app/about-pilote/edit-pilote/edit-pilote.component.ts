import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, NgForm } from '@angular/forms';
import { Pilote } from '../../pilote';
import { HttpClientService } from '../../service/httpclient.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-edit-pilote',
  templateUrl: './edit-pilote.component.html',
  styleUrls: ['./edit-pilote.component.css']
})
export class EditPiloteComponent implements OnInit {


  constructor(private piloteService: HttpClientService, private formBuilder: FormBuilder, private router: Router) { }

  pilote: Pilote;
  public editForm: FormGroup;
  load: boolean = false;

  ngOnInit() {
     let editId = localStorage.getItem("editPiloteId");
     if(!editId){
       alert("Invalid action.")
       this.router.navigate(['list-pilote']);
       return;
     }
       this.editForm = this.formBuilder.group({
         id: [],
         name: ['', Validators.required],
         site: ['', Validators.required]
       });

       this.piloteService.getPiloteById(+ editId).subscribe(data => {
         this.editForm.setValue(data);
         console.log(this.editForm);  
       });
    }

     onSubmit(){
      this.piloteService.updatePilote(this.editForm.value).
      pipe(first()).subscribe(
        data => {
          this.router.navigate(['list-pilote'])
          console.log(data);  
        },
        error => {
          alert('Error' + error);
        });
    }


    /* onFormSubmit(form:NgForm) {
      this.load = true;
      this.api.addProduct(form)
        .subscribe(res => {
            let id = res['_id'];
            this.load = false;
            this.router.navigate(['/product-details', id]);
          }, (err) => {
            console.log(err);
            this.load = false;
          });
    }
 */
   
}

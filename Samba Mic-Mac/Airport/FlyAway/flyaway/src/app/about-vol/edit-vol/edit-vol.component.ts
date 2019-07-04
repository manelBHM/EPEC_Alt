import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators, FormControl, ReactiveFormsModule } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Vol } from '../../vol';
import { VolService } from '../../service/vol.service';
import { Observable } from 'rxjs';
//import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';


@Component({
  selector: 'app-edit-vol',
  templateUrl: './edit-vol.component.html',
  styleUrls: ['./edit-vol.component.css']
})
export class EditVolComponent implements OnInit {

  constructor(private router: Router, private volService: VolService, private formBuilder: FormBuilder) { }
  
   public vol: Vol;
   addForm: FormGroup;
   load: boolean = false;

  ngOnInit() {
    let editId = localStorage.getItem("editVolId");
    if(!editId){
      alert("Invalid action.")
      this.router.navigate(['list-vol']);
      return;   
    }
    
    this.addForm = this.formBuilder.group({
      id: [],
      pilote: ['', Validators.required],
      avion: ['', Validators.required],
      depart: ['', Validators.required],
      arrive: ['', Validators.required],
      heured: ['', Validators.required],
      heurea: ['', Validators.required]
  });


  this.volService.getVolById(+ editId).subscribe(data => {
    this.addForm.setValue(data);
    console.log(this.addForm);  
  });
  }

  onSubmit(){  
    this.volService.updateVol(this.addForm.value).
    pipe(first()).subscribe(
      data => {
        this.router.navigate(['list-vol']);
        console.log(data);
      }, 
      error => {
        alert('ERROR' + error)
      }); 
  }
}
/*   updateForm(){
    this.editForm.patchValue({
      id: this.vol.id,
      avion: this.vol.avion,
      pilote: this.vol.pilote,
      siteArrive: this.vol.siteDepart,
      siteDepart: this.vol.siteArrive,
      heureArrive: this.vol.heureDepart,
      heureDepart: this.vol.heureArrive,
  });
  } */
   
 


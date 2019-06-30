import { Component, OnInit, Input } from '@angular/core';
import { Vol } from '../vol';
import { VolService } from '../service/vol.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl, ReactiveFormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import { Avion } from '../avion';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private volService: VolService, private formBuilder: FormBuilder) { 
    
  }


 public vol: Vol = new Vol();
  vols$: Observable<Object>;

  @Input() depart = ['Bordeaux', 'Toulouse', 'Nantes', 'Nice', 'Bastia', 'Rennes', 'Tours', 'Marseille', 'Lyon', 'Paris'];
  @Input() arrive = ['Paris', 'Bordeaux', 'Toulouse', 'Nantes', 'Nice', 'Bastia', 'Rennes', 'Tours', 'Marseille', 'Lyon'];

  @Input() heured= ['07:00:00', '10:00:00', '13:00:00', '15:00:00', '17:00:00', '18:00:00', '19:00:00', '22:00:00', '23:00:00 '];
  @Input() heurea = ['08:00:00', '13:00:00', '15:00:00', '16:00:00', '19:00:00', '19:00:00', '02:00:00', '04:00:00', '03:00:00 '];
          
  addForm: FormGroup;

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
      avion: ['',  Validators.required],
      depart: ['', Validators.required],
      arrive: ['', Validators.required],
      heured: ['', Validators.required],
      heurea: ['', Validators.required],
     
     // city: ['', Validators.required],
      //citys: ['', Validators.required]
    });   

    this.volService.getVolById(+ editId).subscribe(data => {
      this.addForm.setValue(data);
      console.log(this.addForm);  
    });
  }

  onSubmit() {
    console.log(this.addForm);
    this.volService.createVol(this.addForm.value)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['list-vol']);
     });
  }
}

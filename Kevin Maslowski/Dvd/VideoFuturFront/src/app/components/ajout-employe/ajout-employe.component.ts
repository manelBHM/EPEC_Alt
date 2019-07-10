import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Rx';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-ajout-employe',
  templateUrl: './ajout-employe.component.html',
  styleUrls: ['./ajout-employe.component.css']
})
export class AjoutEmployeComponent implements OnInit {

  employeeform: FormGroup;
  validMessage: String = "";

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employeeform = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    })
  }

  submitRegistration() {
    if (this.employeeform.valid) {
      this.validMessage = "Votre employé a bien été ajouté à la base de données. Merci ! :-)";
      this.employeeService.createEmployeeRegistration(this.employeeform.value).subscribe(
        data => {
          this.employeeform.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      )
    } else {
      this.validMessage = "S'il vous plait, complétez le formulaire avant de l'envoyer."
    }
  }

}

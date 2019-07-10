import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Rx';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-creation-user',
  templateUrl: './creation-user.component.html',
  styleUrls: ['./creation-user.component.css']
})
export class CreationUserComponent implements OnInit {

  customerform: FormGroup;
  validMessage: String = "";

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.customerform = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      adress: new FormControl('', Validators.required)
    });
  }

  submitRegistration() {
    if (this.customerform.valid) {
      this.validMessage = "Bienvenue chez Videofutur. Merci ! :-)";
      this.customerService.createCustomerRegistration(this.customerform.value).subscribe(
        data => {
          this.customerform.reset();
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

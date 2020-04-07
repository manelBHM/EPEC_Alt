import {Component, ContentChild, OnInit, ViewChild} from '@angular/core';
import {ProduitService} from '../partage/produit.service';
import {MatFormField, MatFormFieldControl} from '@angular/material/form-field';
import {MatGridList} from '@angular/material/grid-list';
import {Subject} from 'rxjs';
import {MediaChange, MediaObserver} from '@angular/flex-layout';
import {Produit} from '../partage/produit.module';
import {NavigationEnd, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit {
  private url: string;

  constructor(public produitService: ProduitService, public observableMedia: MediaObserver, private router: Router) {
    this.router.events.subscribe( val => {
      if ( val instanceof NavigationEnd) {
        this.produitService.consulterProduits('', 0, 40);
      }
    });
  }

  ngOnInit(): void {
    this.produitService.initializeFormGroup();
     }
  onClear() {
    this.produitService.form.reset();
    this.produitService.initializeFormGroup();
  }

  onSubmitForm() {
    console.log(this.produitService.form.value);
    const form = this.produitService.form.value;

    if( this.produitService.form.value.id == 0) {
      this.produitService.ajouterProduit(form);
      this.router.navigateByUrl('/');
    } else {
      this.produitService.modifierProduit(form);
      this.router.navigateByUrl('/');
    }


  }
}

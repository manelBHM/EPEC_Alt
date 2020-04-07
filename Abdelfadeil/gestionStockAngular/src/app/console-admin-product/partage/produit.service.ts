import { Injectable } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Produit} from './produit.module';
import {HttpClient} from '@angular/common/http';
import {error} from '@angular/compiler/src/util';
import {Observable, of as ObservableOf } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  public produit: Produit;
  public produits: Produit [];
  public host: string = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  form: FormGroup = new FormGroup({
    id: new FormControl(null),
    name: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    prix: new FormControl('0', Validators.required),
    disponible: new FormControl(false, Validators.required),
    photo: new FormControl('')
  });

  initializeFormGroup() {
    this.form.setValue({
      id: 0,
      name: '',
      description: '',
      prix: 0,
      disponible: false,
      photo: ''
    });
  }

  ajouterProduit(form) {
    return this.http.post(this.host + "/produits/ajout-produit", form).subscribe(data => {
      console.log(data);
      this.initializeFormGroup();
    }, err => {
      console.log(error);
    });
  }

  modifierProduit(form) {
    return this.http.put(this.host + "/produits/modif-produit", form).subscribe(data => {
      console.log(data);
      this.initializeFormGroup();
    }, err => {
      console.log(error);
    });
  }

  consulterProduits(mc: string, page: number, size: number)  {
    return this.http.get<any[]>(this.host + "/produits/get-produits?mc=" + mc + "&page=" + page + "&size=" + size);
  }

  suppeimerProduit(id) {
   return this.http.delete(this.host + "/produits/delete-produit-id?id=" + id) ;
  }

  setFormGroup(id) {
   this.http.get<Produit>(this.host + "/produits/get-produit?id=" + id ).subscribe( data => {
     this.produit = data;
     this.form.setValue({
       id: this.produit.id,
       name: this.produit.name,
       description: this.produit.description,
       prix: this.produit.prix,
       disponible: this.produit.disponible,
       photo: this.produit.photo
     });
   }, err => {
     console.log(error);
   });
  }

}

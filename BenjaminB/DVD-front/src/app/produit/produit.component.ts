import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-produit',
  template: `
  <form name="productList" #f="ngForm" (submit)="addProduct()">
    <p>
      produit List :
    </p>
    <li>
    {{ model.Id }}
    </li>
    <p>Add product to list</p>
    <input [(ngModel)]="model.name" name="test"/>
    <button type="submit"><p>save new product</p></button>
    </form>
    `,
  styles: []
})
export class ProduitComponent implements OnInit {
  model: ControllerDvd = {
    Id:0,
    name:'',
  };

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }
  addProduct(): void{
    let url = "http://localhost:8080/";
    this.http.post(url, this.model).subscribe(
      arg => {location.reload()},
    )
  }
    
}
export interface ControllerDvd{
  Id:number;
  name:String;
}
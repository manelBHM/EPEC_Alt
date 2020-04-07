import {Injectable, NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import {CollectionViewer, DataSource} from '@angular/cdk/collections';
import {Observable} from 'rxjs';





export class Produit {
  constructor() {
  }
     id: number;
     name: string;
     description: string;
     prix: number;
     disponible: boolean;
     photo: string;


}
export class StaticDataSource extends DataSource<Produit> {
  constructor(public staticData: Observable<Produit[]>) {
    super();
  }



  disconnect() {}

  connect(collectionViewer: CollectionViewer): Observable<Produit[] | ReadonlyArray<Produit>> {
    return Observable.create(this.disconnect());
  }
}

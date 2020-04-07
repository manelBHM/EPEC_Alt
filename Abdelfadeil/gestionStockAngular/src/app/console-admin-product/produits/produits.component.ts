import {Component, Input, OnInit, ViewChild, ChangeDetectorRef} from '@angular/core';
import {Produit, StaticDataSource} from '../partage/produit.module';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator, PageEvent} from '@angular/material/paginator';
import {ProduitService} from '../partage/produit.service';
import {FormGroup} from '@angular/forms';
import {CollectionViewer, DataSource} from '@angular/cdk/collections';
import {BehaviorSubject, Observable, of as ObservableOf } from 'rxjs';
import {map} from 'rxjs/operators';
import {ActivatedRoute, NavigationEnd, Route, Router} from '@angular/router';







@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {

  id: number;
  name: string;
  description: string;
  prix: number;
  disponible: boolean;
  photo: string;



  @ViewChild(MatSort, {static: true}) sort: MatSort;
  produits: any[];
  data;
  constructor(public produitService: ProduitService, private router: Router) {
    this.router.events.subscribe( val => {
      if ( val instanceof NavigationEnd) {
        this.produitService.consulterProduitsMisAjour('', 0, 40).subscribe( data => {
          this.produitService.dataSource = data['content'];
        }, error => {
          console.log(error);
        });
      }
    });
  }

  ngOnInit(): void {
     this.consulterProduits();
  }
      displayedColumns : string[] = ['id', 'name', 'description', 'prix', 'disponible', 'photo', 'delete'];
      pageEvent: PageEvent;


  consulterProduits() {
   // this.dataSource = this.asyncConsulterProduits();
    this.produitService.consulterProduits(this.produitService.mc, this.produitService.page, this.produitService.size);
  }

  onDelete(event, id) {
    if ( event.toElement.className === 'fa fa-trash' || event.toElement.className === 'mat-focus-indicator mat-button mat-button-base mat-warn cdk-focused cdk-mouse-focused' || event.toElement.className === 'mat-focus-indicator mat-button mat-button-base mat-warn cdk-focused cdk-mouse-focused') {
      let conf = confirm("Êtes vous sûr de vouloir supprimer?");
      if (conf) {
        this.produitService.suppeimerProduit(id).subscribe(data => {
          this.consulterProduits();
        }, error => {
          console.log(error);
        });
      }
    }
  }

  onUpdate(event, row) {
     if (event.toElement.className.toString() !== 'mat-focus-indicator mat-button mat-button-base mat-warn cdk-focused cdk-mouse-focused') {
    if ( event.toElement.className !== 'fa fa-trash' || event.toElement.className === 'mat-cell cdk-cell cdk-column-delete mat-column-delete ng-star-inserted') {
      console.log(event.toElement.className );
      console.log(event);
      console.log(row);
      console.log(this.produitService.form);
      this.produitService.setFormGroup(row);
    }
     }
  }

  async asyncConsulterProduits() {
    const result = await this.produitService.consulterProduitsMisAjour(this.produitService.mc, this.produitService.page, this.produitService.size);
    return  result;
  }
}

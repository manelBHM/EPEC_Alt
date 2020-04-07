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







@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent extends DataSource<Produit> implements OnInit {

  id: number;
  name: string;
  description: string;
  prix: number;
  disponible: boolean;
  photo: string;

  mc: string = '';
  page: number = 0;
  size: number = 40;

  @ViewChild(MatSort, {static: true}) sort: MatSort;
  produits: any[];
  dataSource: Promise<any[]>;
  data;
  public produits$ = new BehaviorSubject(this.produits);


  constructor(public produitService: ProduitService, public changeDetectorRefs: ChangeDetectorRef) {
    super();
    setInterval(() => {
      this.consulterProduits();
    }, 1000);
  }

  trackById(index, produit) {
    return produit.id;
  }

  ngOnInit(): void {
   // this.produits$ = this.produits$.pipe(map(v => Object.values(v)));
     this.consulterProduits();
    //  this.dataSource.sort = this.sort;
  }
      displayedColumns : string[] = ['id', 'name', 'description', 'prix', 'disponible', 'photo', 'delete'];
      pageEvent: PageEvent;


  consulterProduits() {
   // this.dataSource = this.asyncConsulterProduits();
    this.produitService.consulterProduits(this.mc, this.page, this.size).subscribe(data => {
      this.dataSource  = data['content'];
    }, error => {
    });
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
      console.log(this.produitService.form)
      this.produitService.setFormGroup(row);
    }
     }
  }

  async asyncConsulterProduits() {
    const result = await this.produitService.consulterProduits(this.mc, this.page, this.size).toPromise();
    return  result;
  }

  connect(collectionViewer: CollectionViewer): Observable<Produit[] | readonly Produit[]> {
    throw ObservableOf(this.dataSource);
  }
  disconnect(collectionViewer: CollectionViewer): void {
    throw new Error("Method not implemented.");
  }
}

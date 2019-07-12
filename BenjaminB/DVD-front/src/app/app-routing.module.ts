import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ClientComponent} from './client/client.component';
import {ProduitComponent} from './produit/produit.component';
import {FactureComponent} from './facture/facture.component';


const routes: Routes = [

{path: 'client', component:ClientComponent},
{path: 'produit', component: ProduitComponent},
{path: 'facture', component: FactureComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [ClientComponent,ProduitComponent]
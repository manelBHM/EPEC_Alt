import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ConsoleAdminProductComponent} from './console-admin-product/console-admin-product.component';


const routes: Routes = [
  { path: 'console-admin-produit', component: ConsoleAdminProductComponent},
  { path: '', redirectTo: 'console-admin-produit', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

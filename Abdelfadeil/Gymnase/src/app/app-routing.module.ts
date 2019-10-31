import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {ActivitesComponent} from './activites/activites.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {ContactComponent} from './contact/contact.component';
import {LocauxComponent} from './locaux/locaux.component';
import {InscriptionComponent} from './inscription/inscription.component';


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  { path: 'activities', component: ActivitesComponent},
  {path: 'activites', component: ActivitesComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'locaux', component: LocauxComponent},
  { path: 'inscription', component: InscriptionComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

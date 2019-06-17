import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VolsComponent } from './vols/vols.component';
import { PilotesComponent } from './pilotes/pilotes.component';
import { AvionsComponent } from './avions/avions.component';
import { HomeComponent } from './home/home.component';
import { AjouterComponent } from './ajouter/ajouter.component';
import { EditerComponent } from './editer/editer.component';
import { AjouterPiloteComponent } from './ajouter-pilote/ajouter-pilote.component';
import { AjouterAvionComponent } from './ajouter-avion/ajouter-avion.component';
import { NotFoundComponent } from './not-found/not-found.component';


const routes: Routes = [
  { path: 'vols', component: VolsComponent },
  { path: 'pilotes', component: PilotesComponent },
  { path: 'avions', component: AvionsComponent },
  { path: 'ajouter', component: AjouterComponent},
  { path: 'ajouterPilote', component: AjouterPiloteComponent},
  { path: 'ajouterAvion', component: AjouterAvionComponent},
  { path: 'editer/:id', component: EditerComponent},
  { path: 'accueil', component: HomeComponent },
  { path: '',  redirectTo: 'accueil',  pathMatch: 'full'},
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes) 
    
  ],
    exports: [ RouterModule ]
})
export class AppRoutingModule { }

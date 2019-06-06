import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VolsComponent } from './vols/vols.component';
import { PilotesComponent } from './pilotes/pilotes.component';
import { AvionsComponent } from './avions/avions.component';
import { HomeComponent } from './home/home.component';
import { AjouterComponent } from './ajouter/ajouter.component';
import { EditerComponent } from './editer/editer.component';


const routes: Routes = [
  { path: 'vols', component: VolsComponent },
  { path: 'pilotes', component: PilotesComponent },
  { path: 'avions', component: AvionsComponent },
  { path: '', component: HomeComponent },
  { path: 'ajouter', component: AjouterComponent},
  { path: 'editer/:id', component: EditerComponent}
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes) 
    
  ],
    exports: [ RouterModule ]
})
export class AppRoutingModule { }

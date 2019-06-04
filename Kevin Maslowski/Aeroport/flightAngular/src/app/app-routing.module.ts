import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AvionComponent } from './components/avion/avion.component';
import { VolComponent } from './components/vol/vol.component';
import { PiloteComponent } from './components/pilote/pilote.component';
import { AjoutpiloteComponent } from './components/ajoutpilote/ajoutpilote.component'
import { AjoutavionComponent } from './components/ajoutavion/ajoutavion.component';
import { AjoutvolComponent } from './components/ajoutvol/ajoutvol.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { ViewAvionComponent } from './components/view-avion/view-avion.component';
import { ViewPiloteComponent } from './components/view-pilote/view-pilote.component';
import { ViewVolComponent } from './components/view-vol/view-vol.component';
import { LoginComponent } from './components/login/login.component'
import { PilotePageComponent } from './components/pilote-page/pilote-page.component'

const routes: Routes = [
  {
    path: 'admin/pilotes/view/:id',
    component: ViewPiloteComponent
  },
  {
    path: 'admin/avions/view/:id',
    component: ViewAvionComponent
  },
  {
    path: 'admin/vols/view/:id',
    component: ViewVolComponent
  },
  {
    path: 'admin/pilotes',
    component: PiloteComponent
  },
  {
    path: 'admin/avions',
    component: AvionComponent
  },
  {
    path: 'admin/vols',
    component: VolComponent
  },
  {
    path: 'admin/addpilote',
    component: AjoutpiloteComponent
  },
  {
    path: 'admin/addavion',
    component: AjoutavionComponent
  },
  {
    path: 'admin/addvol',
    component: AjoutvolComponent
  },
  {
    path: 'admin/acceuil',
    component: AccueilComponent
  },
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'acceuil',
    component: PilotePageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

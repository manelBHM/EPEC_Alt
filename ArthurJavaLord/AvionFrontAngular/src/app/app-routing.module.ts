import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import {HomeComponent} from './components/home/home.component';
import {ViewRegistrationComponent} from './components/view-registration/view-registration.component';
import {PlaneRegComponent} from './components/plane-reg/plane-reg.component';
import {PiloteRegComponent} from './components/pilote-reg/pilote-reg.component';
import {FlightRegComponent} from './components/flight-reg/flight-reg.component';
import {FlightviewComponent} from './components/flightview/flightview.component';




const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'admin/view/:id',
    component: ViewRegistrationComponent  },
  {
    path:'admin/flight/:id',
    component: FlightviewComponent  },
  {
    path:'admin',
    component: AdminComponent  },
  {
    path:'reg/plane',
    component: PlaneRegComponent
  },
  {
    path:'reg/pilote',
    component: PiloteRegComponent
  },
  {
    path:'reg/flight',
    component: FlightRegComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

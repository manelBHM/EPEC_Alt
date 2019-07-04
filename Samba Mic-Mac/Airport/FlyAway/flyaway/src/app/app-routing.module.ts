import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
//import { EmployeeComponent } from './employee/employee.component';
//import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { PiloteComponent } from './about-pilote/pilote/pilote.component';
import { ListPiloteComponent } from './about-pilote/list-pilote/list-pilote.component';
import { EditPiloteComponent } from './about-pilote/edit-pilote/edit-pilote.component';
import { AddPiloteComponent } from './about-pilote/add-pilote/add-pilote.component';

import { ListAvionComponent } from './about-avion/list-avion/list-avion.component';
import { EditAvionComponent } from './about-avion/edit-avion/edit-avion.component';
import { AddAvionComponent } from './about-avion/add-avion/add-avion.component';
import { CreateAvionComponent } from './about-avion/create-avion/create-avion.component';
import { HomeComponent } from './home/home.component';
import { ListVolComponent } from './about-vol/list-vol/list-vol.component';
import { EditVolComponent } from './about-vol/edit-vol/edit-vol.component';
import { CreateVolComponent } from './about-vol/create-vol/create-vol.component';

const routes: Routes = [
  //{ path: '', component: EmployeeComponent},
  //{path: '', component: ListPiloteComponent},
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  
  {path: 'login', component: LoginComponent },
  {path: 'list-pilote', component: ListPiloteComponent},
  {path: 'edit-pilote', component: EditPiloteComponent},
  {path: 'add-pilote',  component: AddPiloteComponent },

  {path: 'list-avion', component: ListAvionComponent},
  {path: 'edit-avion', component: EditAvionComponent},
  {path: 'add-avion', component:  AddAvionComponent},

  {path: 'list-vol', component: ListVolComponent},
  {path: 'edit-vol', component: EditVolComponent},
  {path: 'create-vol', component:  CreateVolComponent},
 
  
  {path: 'create-avion', component:  CreateAvionComponent},
  { path: 'logout', component: LogoutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
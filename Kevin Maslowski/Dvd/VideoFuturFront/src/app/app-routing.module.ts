import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccueilComponent } from './components/accueil/accueil.component';
import { LoginComponent } from './components/login/login.component';
import { AjoutDvdComponent } from './components/ajout-dvd/ajout-dvd.component';
import { CreationUserComponent } from './components/creation-user/creation-user.component';
import { AccueilAdminComponent } from './components/accueil-admin/accueil-admin.component';
import { CartComponent } from './components/cart/cart.component';
import { ViewFilmsComponent } from './components/view-films/view-films.component';
import { ViewCustomersComponent } from './components/view-customers/view-customers.component';
import { AjoutEmployeComponent } from './components/ajout-employe/ajout-employe.component';
import { ViewEmployeeComponent } from './components/view-employee/view-employee.component';
import { ViewOrderComponent } from './components/view-order/view-order.component';
import { ListOrderComponent } from './components/list-order/list-order.component';
import { ListFilmsComponent } from './components/list-films/list-films.component';
import { ListEmployeesComponent } from './components/list-employees/list-employees.component';
import { ListCustomerComponent } from './components/list-customer/list-customer.component';
import { from } from 'rxjs';

const routes: Routes = [
  {
    path: 'SuperAdmin/employee/view/:id',
    component: ViewEmployeeComponent
  },
  {
    path: 'SuperAdmin/order/view/:id',
    component: ViewOrderComponent
  },
  {
    path: 'SuperAdmin/ordersList',
    component: ListOrderComponent
  },
  {
    path: 'SuperAdmin/filmsList',
    component: ListFilmsComponent
  },
  {
    path: 'SuperAdmin/employeesList',
    component: ListEmployeesComponent
  },
  {
    path: 'SuperAdmin/customersList',
    component: ListCustomerComponent
  },
  {
    path: 'accueil',
    component: AccueilComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'SuperAdmin/addDvd',
    component: AjoutDvdComponent
  },
  {
    path: 'signup',
    component: CreationUserComponent
  },
  {
    path: 'SuperAdmin/accueil',
    component: AccueilAdminComponent
  },
  {
    path: 'cart',
    component: CartComponent
  },{
    path: 'SuperAdmin/film/view/:id',
    component: ViewFilmsComponent
  },
  {
    path: 'SuperAdmin/customer/view/:id',
    component: ViewCustomersComponent
  },
  {
    path: 'SuperAdmin/addEmployee',
    component: AjoutEmployeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

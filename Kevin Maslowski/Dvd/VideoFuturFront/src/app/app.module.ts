import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    LoginComponent,
    AjoutDvdComponent,
    CreationUserComponent,
    AccueilAdminComponent,
    CartComponent,
    ViewFilmsComponent,
    ViewCustomersComponent,
    AjoutEmployeComponent,
    ViewEmployeeComponent,
    ViewOrderComponent,
    ListOrderComponent,
    ListFilmsComponent,
    ListEmployeesComponent,
    ListCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

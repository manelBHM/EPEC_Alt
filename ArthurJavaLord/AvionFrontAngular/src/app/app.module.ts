import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FlightService} from './services/flight.service';
import {PiloteService} from './services/pilote.service';


import {HttpClientModule} from '@angular/common/http';
import { AdminComponent } from './components/admin/admin.component';
import { HomeComponent } from './components/home/home.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ViewRegistrationComponent } from './components/view-registration/view-registration.component';
import { PiloteRegComponent } from './components/pilote-reg/pilote-reg.component';
import { FlightRegComponent } from './components/flight-reg/flight-reg.component';
import { PlaneRegComponent } from './components/plane-reg/plane-reg.component';
import { FlightviewComponent } from './components/flightview/flightview.component';
import { PlaneService } from './services/plane.service';

 
@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HomeComponent,
    ViewRegistrationComponent,
    PiloteRegComponent,
    FlightRegComponent,
    PlaneRegComponent,
    FlightviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [PiloteService, FlightService, PlaneService
              ],
  bootstrap: [AppComponent]
})
export class AppModule { }

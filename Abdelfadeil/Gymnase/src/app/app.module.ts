import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ActivitesComponent } from './activites/activites.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent} from './home/home.component';
import { NotFoundComponent} from './not-found/not-found.component';
import { LocauxComponent } from './locaux/locaux.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ContactComponent } from './contact/contact.component';
import { DataTablesModule } from 'angular-datatables';
import {HttpClientModule} from '@angular/common/http';

declare var require: any;

@NgModule({
  declarations: [
    AppComponent,
    ActivitesComponent,
    HeaderComponent,
    HomeComponent,
    NotFoundComponent,
    LocauxComponent,
    InscriptionComponent,
    ContactComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DataTablesModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { VolsComponent } from './vols/vols.component';
import { PilotesComponent } from './pilotes/pilotes.component';
import { AvionsComponent } from './avions/avions.component';
import { HomeComponent } from './home/home.component';
import { AjouterComponent } from './ajouter/ajouter.component';
import { EditerComponent } from './editer/editer.component';
import { AjouterPiloteComponent } from './ajouter-pilote/ajouter-pilote.component';
import { AjouterAvionComponent } from './ajouter-avion/ajouter-avion.component';
import { NotFoundComponent } from './not-found/not-found.component';


@NgModule({
  declarations: [
    AppComponent,
    VolsComponent,
    PilotesComponent,
    AvionsComponent,
    HomeComponent,
    AjouterComponent,
    EditerComponent,
    AjouterPiloteComponent,
    AjouterAvionComponent,
    NotFoundComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

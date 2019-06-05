import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PiloteService } from './services/pilote.service';
import { AvionService } from './services/avion.service';
import { VolService } from './services/vol.service';
import { AvionComponent } from './components/avion/avion.component';
import { VolComponent } from './components/vol/vol.component';
import { PiloteComponent } from './components/pilote/pilote.component';
import { AjoutvolComponent } from './components/ajoutvol/ajoutvol.component';
import { AjoutavionComponent } from './components/ajoutavion/ajoutavion.component';
import { AjoutpiloteComponent } from './components/ajoutpilote/ajoutpilote.component';
import { ViewAvionComponent } from './components/view-avion/view-avion.component';
import { ViewVolComponent } from './components/view-vol/view-vol.component';
import { ViewPiloteComponent } from './components/view-pilote/view-pilote.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { PilotePageComponent } from './components/pilote-page/pilote-page.component';
import { LoginComponent } from './components/login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    PiloteComponent,
    AvionComponent,
    VolComponent,
    AjoutpiloteComponent,
    AjoutvolComponent,
    AjoutavionComponent,
    ViewAvionComponent,
    ViewVolComponent,
    ViewPiloteComponent,
    AccueilComponent,
    PilotePageComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [PiloteService, VolService, AvionService],
  bootstrap: [AppComponent]
})
export class AppModule { }

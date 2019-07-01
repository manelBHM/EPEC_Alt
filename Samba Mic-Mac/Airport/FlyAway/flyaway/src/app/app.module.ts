import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { AddPiloteComponent } from './about-pilote/add-pilote/add-pilote.component';
import { PiloteComponent } from './about-pilote/pilote/pilote.component';
import { HomeComponent } from './home/home.component';
import { CreatePiloteComponent } from './about-pilote/create-pilote/create-pilote.component';
import { EditPiloteComponent } from './about-pilote/edit-pilote/edit-pilote.component';
import { ListPiloteComponent } from './about-pilote/list-pilote/list-pilote.component';
import { EditAvionComponent } from './about-avion/edit-avion/edit-avion.component';
import { ListAvionComponent } from './about-avion/list-avion/list-avion.component';
import { AddAvionComponent } from './about-avion/add-avion/add-avion.component';
import { CreateAvionComponent } from './about-avion/create-avion/create-avion.component';
import { ListVolComponent } from './about-vol/list-vol/list-vol.component';
import { EditVolComponent } from './about-vol/edit-vol/edit-vol.component';
import { CreateVolComponent } from './about-vol/create-vol/create-vol.component';

@NgModule({
  declarations: [
    AppComponent,
    //AddEmployeeComponent,
    //EmployeeComponent,
    FooterComponent,
    LoginComponent,
    LogoutComponent,
    HeaderComponent,
    AddPiloteComponent,
    PiloteComponent,
    HomeComponent,
    CreatePiloteComponent,
    EditPiloteComponent,
    ListPiloteComponent,
    EditAvionComponent,
    ListAvionComponent,
    AddAvionComponent,
    CreateAvionComponent,
    ListVolComponent,
    EditVolComponent,
    CreateVolComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

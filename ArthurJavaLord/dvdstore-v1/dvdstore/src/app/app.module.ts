import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {StoreapiService} from './services/storeapi.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatedvdComponent } from './components/createdvd/createdvd.component';
import { DvdlistComponent } from './components/dvdlist/dvdlist.component';
import { DvdspecComponent } from './components/dvdspec/dvdspec.component';
import { CustomercreationComponent } from './components/customercreation/customercreation.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { CartComponent } from './components/cart/cart.component';
import { UserlistComponent } from './components/userlist/userlist.component';
import { DvdComponent } from './components/dvd/dvd.component';
import { CustComponent } from './components/cust/cust.component';

@NgModule({
  declarations: [
    AppComponent,
    CreatedvdComponent,
    DvdlistComponent,
    DvdspecComponent,
    CustomercreationComponent,
    HomepageComponent,
    CartComponent,
    UserlistComponent,
    DvdComponent,
    CustComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [StoreapiService],
  bootstrap: [AppComponent]
})
export class AppModule { }

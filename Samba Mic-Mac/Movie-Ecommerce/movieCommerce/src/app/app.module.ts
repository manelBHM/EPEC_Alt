import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ServicesComponent } from './service/services/services.component';
import { ArticleComponent } from './services/article/article.component';
import { ArticlesComponent } from './model/articles/articles.component';
import { UserComponent } from './model/user/user.component';
import { PannierComponent } from './model/pannier/pannier.component';
import { VenteComponent } from './model/vente/vente.component';

@NgModule({
  declarations: [
    AppComponent,
    ServicesComponent,
    ArticleComponent,
    ArticlesComponent,
    UserComponent,
    PannierComponent,
    VenteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

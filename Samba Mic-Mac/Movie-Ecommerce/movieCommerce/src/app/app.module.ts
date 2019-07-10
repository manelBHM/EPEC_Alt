import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { ArticleComponent } from './article/article.component';
import { ArticlesComponent } from './articles/articles.component';
import { UserComponent } from './user/user.component';
import { PannierComponent } from './pannier/pannier.component';
import { VenteComponent } from './vente/vente.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { MenuComponent } from './menu/menu.component';
import { SlideAreaComponent } from './slide-area/slide-area.component';
import { EcommerceComponent } from './ecommerce/ecommerce.component';
import { CommandeComponent } from './commande/commande.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
   declarations: [
    AppComponent,
    ArticleComponent,
    ArticlesComponent,
    UserComponent,
    PannierComponent,
    VenteComponent,
    HomeComponent,
    HeaderComponent,
    MenuComponent,
    SlideAreaComponent,
    EcommerceComponent,
    CommandeComponent,
    LoginComponent,
    RegisterComponent,
    PageNotFoundComponent,
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

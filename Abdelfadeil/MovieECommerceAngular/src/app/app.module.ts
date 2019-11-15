import { BrowserModule } from '@angular/platform-browser';
import { NgModule, OnInit } from '@angular/core';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ArticlesComponent } from './articles/articles.component';
import { AdminConsoleComponent } from './admin-console/admin-console.component';
import { DataTablesModule } from 'angular-datatables';
import { FlxUiDatatableModule,FlxUiDataTable } from 'flx-ui-datatable';
import { AjouterArticleComponent } from './ajouter-article/ajouter-article.component';
import { EditerArticleComponent } from './editer-article/editer-article.component';
import { PanierComponent } from './panier/panier.component';
import { AuthentificationService } from './service/authentification.service';
import { MailingComponent } from './mailing/mailing.component';


declare var require: any;

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    NotFoundComponent,
    ArticlesComponent,
    AdminConsoleComponent,
    AjouterArticleComponent,
    EditerArticleComponent,
    PanierComponent,
    MailingComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularFontAwesomeModule,
    FormsModule,
    HttpClientModule,
    FlxUiDatatableModule,
    DataTablesModule,
    DataTablesModule.forRoot()
  ],
  providers: [FlxUiDataTable],
  bootstrap: [AppComponent]
})
export class AppModule implements OnInit{
 
  constructor(private autService:AuthentificationService){}


  ngOnInit(): void {
   
  }




}

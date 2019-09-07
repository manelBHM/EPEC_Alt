import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AdminConsoleComponent } from './admin-console/admin-console.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ArticlesComponent } from './articles/articles.component';
import { AjouterArticleComponent } from './ajouter-article/ajouter-article.component';
import { PanierComponent } from './panier/panier.component';
import { EditerArticleComponent } from './editer-article/editer-article.component';

const routes: Routes = [
  { path: 'register', component: RegisterComponent},
  { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent},
    { path: 'articles/:id', component: ArticlesComponent},
    { path: 'admin-console', component: AdminConsoleComponent},
    { path: 'ajouter-article', component: AjouterArticleComponent},
    { path: 'editer-article/:id', component: EditerArticleComponent},
    { path: 'article/:id', component: EditerArticleComponent},
    { path: 'panier', component: PanierComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: '**', component: NotFoundComponent }





];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule, HttpClientModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }

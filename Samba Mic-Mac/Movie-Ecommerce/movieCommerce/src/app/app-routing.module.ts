import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PannierComponent } from './pannier/pannier.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ArticlesComponent } from './articles/articles.component';
import { ArticleComponent } from './article/article.component';





const routes: Routes = [

  { path: '',  redirectTo: 'home',  pathMatch: 'full'},
{ path: 'home', component: HomeComponent }, 
{ path: 'login', component: LoginComponent },
{ path: 'register', component: RegisterComponent },
{ path: 'articles', component: ArticlesComponent },
{ path: 'articles/id', component: ArticleComponent },
{ path: 'pannier', component: PannierComponent },
{ path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  providers: [NgModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }

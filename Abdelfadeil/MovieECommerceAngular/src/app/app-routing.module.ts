import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';

import { NotFoundComponent } from './not-found/not-found.component';
import { ArticlesComponent } from './articles/articles.component';

const routes: Routes = [
  { path: 'register', component: RegisterComponent},
  { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent},
    { path: 'articles', component: ArticlesComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: '**', component: NotFoundComponent }





];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule, HttpClientModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }

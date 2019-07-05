import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PannierComponent } from './pannier/pannier.component';





const routes: Routes = [
 {
  path: '', component: HomeComponent,
  //pathMatch: 'full'
}, 
{
  path: 'home', component: HomeComponent
}, 
{
  path: 'login', component: LoginComponent
},
 
{
  path: 'register', component: RegisterComponent
},
{
  path: 'pannier', component: PannierComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  providers: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }

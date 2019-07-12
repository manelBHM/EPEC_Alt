import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DvdlistComponent } from './components/dvdlist/dvdlist.component';
import { DvdspecComponent } from './components/dvdspec/dvdspec.component';
import { CreatedvdComponent } from './components/createdvd/createdvd.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { CustomercreationComponent } from './components/customercreation/customercreation.component';
import { CartComponent } from './components/cart/cart.component';
import { UserlistComponent } from './components/userlist/userlist.component';
import { DvdComponent } from './components/dvd/dvd.component';
import { CustComponent } from './components/cust/cust.component';





const routes: Routes = [
 
  {
    path:'admin-view',
    component:DvdlistComponent
  },
  {
    path: 'dvdlist/:id',
  component: DvdspecComponent
  },
  {
    path: 'registration',
  component: CreatedvdComponent
  }
  ,
  {
    path: '',
  component: HomepageComponent
  }
  ,
  {
    path: 'customercreation',
  component: CustomercreationComponent
  }
  ,
  {
    path: 'cart',
  component: CartComponent
  }
  ,
  {
    path: 'list',
  component: UserlistComponent
  }
  ,
  {
    path: 'dvd/:id',
  component: DvdComponent

  }
  ,
  {
    path: 'cust/:id',
  component: CustComponent

  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

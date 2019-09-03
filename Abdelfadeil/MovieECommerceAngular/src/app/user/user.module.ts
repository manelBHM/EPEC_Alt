import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class UserModule {
 

 constructor(
   public username: String,
    public password: String, 
    public repassword: String
   ){

 }
 }

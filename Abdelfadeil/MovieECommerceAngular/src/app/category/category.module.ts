import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class CategoryModule {



  constructor(id:number, name:String, description:String){
    this.id= id;
    this.name=name;
    this.description=description;
  }
  id:number;
  name:String;
  description:String;




}

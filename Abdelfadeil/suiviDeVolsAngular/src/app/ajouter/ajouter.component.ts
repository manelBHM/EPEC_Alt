import { Component, OnInit } from '@angular/core';
import { ModelVol } from '../../model/Model.vol'
import { VolsService } from '../vols.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ajouter',
  templateUrl: './ajouter.component.html',
  styleUrls: ['./ajouter.component.css']
})
export class AjouterComponent implements OnInit {
  
   
  modelVol = new ModelVol();
  

  constructor(private volsService:VolsService, private router:Router) { }

  ngOnInit() {
  }

  ajouterVol(){
    console.log(this.modelVol)
  
   return  this.volsService.ajoutVol(this.modelVol).subscribe(data=> {
      console.log(data);
      this.router.navigateByUrl("/vols");
    }, err=> {
      console.log(err);
    })
  }

  supprimerVol(id:number){
    this.volsService.supprimer(id).subscribe(data=>{
      console.log(data)
    },err=>{
      console.log(err)
    })}

}

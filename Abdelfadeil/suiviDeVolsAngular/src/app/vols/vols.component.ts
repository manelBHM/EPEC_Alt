import { Component, OnInit } from '@angular/core';
import { VolsService } from '../vols.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-vols',
  templateUrl: './vols.component.html',
  styleUrls: ['./vols.component.css']
})
export class VolsComponent implements OnInit {
  vols;
  currentPage:number=0;
  page:number=0;
  size:number=5;
  totalPages: number;
  pages: number[];
  currentMotCle: String="";

  constructor(private router:Router, private volsService:VolsService) {

   }

  ngOnInit() {
    this.chercherVols();
  }
  supprimerVol(v){
    let conf=confirm("Êtes vous sûr de vouloir supprimer?");
    if(conf) {
      this.volsService.supprimer(v._links.self.href).subscribe(data=>{
        this.chercherVols();
      },err=>{
        console.log(err)
      })}

    }

    onPageVols(i){
      this.currentPage=i;
      this.onChercher({motCle:this.currentMotCle});
    }
  onGetVols() {
    this.volsService.getVols(this.currentPage, this.size).subscribe(data=> {
      this.totalPages=data["page"].totalPages;
      this.pages= new Array<number>(this.totalPages);
      this.vols=data;
  
    }, err=> {
      console.log(err);
    })
  }
  onChercher(form:any){
    console.log(form.motCle)
    this.currentMotCle=form.motCle;
    this.chercherVols();
  }

    chercherVols(){
      this.volsService.getVolsByKeyNom(this.currentMotCle, this.currentPage, this.size).subscribe(data=> {
        this.totalPages=data["page"].totalPages;
        this.pages= new Array<number>(this.totalPages);
        this.vols=data;
    
      }, err=> {
        console.log(err);
      })
    }

    onEdit(v){
      let url = v._links.self.href;
      this.router.navigateByUrl("/editer/"+btoa(url));
    }

  title = 'Plan des Vols';
}

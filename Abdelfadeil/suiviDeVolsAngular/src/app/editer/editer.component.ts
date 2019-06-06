import { Component, OnInit } from '@angular/core';
import { ModelVol } from 'src/model/Model.vol';
import { Router, ActivatedRoute } from '@angular/router';
import { VolsService } from '../vols.service';

@Component({
  selector: 'app-editer',
  templateUrl: './editer.component.html',
  styleUrls: ['./editer.component.css']
})
export class EditerComponent implements OnInit {

  private currentVol;
  url: any;
  constructor(private router:Router, private activatedRoute:ActivatedRoute, private volsService:VolsService) { }

  ngOnInit() {
   this.url= atob(this.activatedRoute.snapshot.params.id);
    this.volsService.getVol(this.url).subscribe(data => {
      this.currentVol=data;
      console.log(this.url);
    }, err=>{
      console.log(err);
    })  }

    onUpdateVol(value:any){
      this.volsService.editerVol(this.url, value).subscribe(data => {
          alert("mis à jour effectuée avec succès");
          this.router.navigateByUrl("/vols");
      }, err=>{
        console.log(err);
      })
    }

}

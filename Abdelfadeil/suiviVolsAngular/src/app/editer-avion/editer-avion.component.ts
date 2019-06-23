import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AvionsService } from '../services/avions.service';
import { AvionModel } from 'src/model/avion.model';

@Component({
  selector: 'app-editer-avion',
  templateUrl: './editer-avion.component.html',
  styleUrls: ['./editer-avion.component.css']
})
export class EditerAvionComponent implements OnInit {

  currentAvion:AvionModel;
  url: any;
  constructor(private router:Router, private activatedRoute:ActivatedRoute, private avionsService:AvionsService) { }

  ngOnInit() {
   this.url= atob(this.activatedRoute.snapshot.params.id);
    this.avionsService.getAvion(this.url).subscribe(data => {
      this.currentAvion=data;
    }, err=>{
      console.log(err);
    })  }

    onUpdateAvion(value:any){
      this.avionsService.editerAvion(this.url, value).subscribe(data => {
          alert("mis à jour effectuée avec succès");
          this.router.navigateByUrl("/avions");
      }, err=>{
        console.log(err);
      })
    }


}

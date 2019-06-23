import { Component, OnInit } from '@angular/core';
import { AvionsService } from '../services/avions.service';
import { AvionModel } from 'src/model/avion.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-avions',
  templateUrl: './avions.component.html',
  styleUrls: ['./avions.component.css']
})
export class AvionsComponent implements OnInit {

  currentPage:number=0;
  page:number=0;
  size:number=5;
  totalPages: number;
  pages: number[];
  currentMotCle: String="";

  title = "Liste d'Avons";
  avions: AvionModel;

  constructor(private avionsService: AvionsService, private router:Router) { }

  ngOnInit() {
      this.avionsService.getAvions({ mc: this.currentMotCle, page: this.currentPage, size: this.size }).subscribe(data => {
      console.log(data);
      this.totalPages=data["page"].totalPages;
      this.pages= new Array<number>(this.totalPages);
      this.avions= data;
    },error => {
      console.log(error);
    });
  }

  onChercher(form:any){
    this.currentMotCle=form.motCle;
    this.avionsService.getAvions({ mc: this.currentMotCle, page: this.currentPage, size: this.size }).subscribe(data => {
    this.totalPages=data["page"].totalPages;
    this.pages= new Array<number>(this.totalPages);
    this.avions= data;
    }, error => {
      console.log(error);
    })
  }

  onPageAvions(i) {
    this.currentPage= i;
    this.onChercher({motCle:this.currentMotCle});
  }

  onDelete(a){
    let conf=confirm("Êtes vous sûr de vouloir supprimer?");
     if(conf){
       this.avionsService.delete(a._links.self.href).subscribe(data => {
        this.onChercher('');
       }, error => {
         console.log(error);
       });
     }
  }

  onUpdate(a){
    let url = a._links.self.href;
    this.router.navigateByUrl("/editer-avion/"+btoa(url));
  }
 
}

import { Component, OnInit } from '@angular/core';
import { Observable} from 'rxjs';
import { Router } from '@angular/router';
import { AvionService } from '../../service/avion.service';
import { Avion } from '../../avion';

@Component({
  selector: 'app-list-avion',
  templateUrl: './list-avion.component.html',
  styleUrls: ['./list-avion.component.css']
})
export class ListAvionComponent implements OnInit {

  constructor(private router: Router, private avionService: AvionService) { }

  avions$ : Observable<Avion[]>

  ngOnInit() {
    this.reloadData();
  }

  deleteAvion(id: number){
     this.avionService.deleteAvion(id).
     subscribe(date => {
       console.log(date);
       this.reloadData(); 
     },
       error => console.log('Error' + error));
  }

  reloadData(){
    this.avions$ = this.avionService.getAvion();
  }

  editAvion(avion: Avion): void {
  localStorage.removeItem("editAvionId")
  console.log(avion);
  localStorage.setItem("editAvionId", avion.id.toString());
   this.router.navigate(['edit-avion'])
  }

  addAvion(id: number){
   this.router.navigate(['list-avion']);
  }
}

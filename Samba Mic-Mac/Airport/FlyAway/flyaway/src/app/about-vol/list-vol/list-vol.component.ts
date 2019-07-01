import { Component, OnInit } from '@angular/core';
import { Vol } from '../../vol';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { VolService } from '../../service/vol.service';


@Component({
  selector: 'app-list-vol',
  templateUrl: './list-vol.component.html',
  styleUrls: ['./list-vol.component.css']
})
export class ListVolComponent implements OnInit {

  constructor(private router: Router, private volService: VolService) { }

  vols$: Observable<Vol[]>;

  ngOnInit() {
    this.reloadData();
  }

  deleteVol(id: number){
    this.volService.deleteVol(id).subscribe(
      data => {
      console.log(data);
      this.reloadData(); 
    }, error => console.log('Error' + error));
  }

  reloadData(){
    this.vols$ = this.volService.getVol();
  }

  editVol(vol: Vol): void {
    localStorage.removeItem("editVolId");
    console.log(vol );
    localStorage.setItem("editVolId", vol.id.toString());
    this.router.navigate(['edit-vol']);
  }

  addVol(id: number){
    this.router.navigate(['list-vol']);
   }
}

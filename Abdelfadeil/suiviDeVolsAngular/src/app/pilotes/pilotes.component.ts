import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pilotes',
  templateUrl: './pilotes.component.html',
  styleUrls: ['./pilotes.component.css']
})
export class PilotesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  title = 'Liste des Pilotes';
}

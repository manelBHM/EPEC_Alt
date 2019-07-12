import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-facture',
  template: `
    <p>
      {{ message }}
    </p>
  `,
  styles: []
})
export class FactureComponent implements OnInit {

  message: string = "this is the bill";

  constructor() { }

  ngOnInit() {
  }

}

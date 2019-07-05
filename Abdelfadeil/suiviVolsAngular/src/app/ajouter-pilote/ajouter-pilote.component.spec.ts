import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterPiloteComponent } from './ajouter-pilote.component';

describe('AjouterPiloteComponent', () => {
  let component: AjouterPiloteComponent;
  let fixture: ComponentFixture<AjouterPiloteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterPiloteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterPiloteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

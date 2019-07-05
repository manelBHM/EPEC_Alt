import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterAvionComponent } from './ajouter-avion.component';

describe('AjouterAvionComponent', () => {
  let component: AjouterAvionComponent;
  let fixture: ComponentFixture<AjouterAvionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterAvionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterAvionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutDvdComponent } from './ajout-dvd.component';

describe('AjoutDvdComponent', () => {
  let component: AjoutDvdComponent;
  let fixture: ComponentFixture<AjoutDvdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjoutDvdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjoutDvdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

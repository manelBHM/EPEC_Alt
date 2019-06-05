import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutavionComponent } from './ajoutavion.component';

describe('AjoutavionComponent', () => {
  let component: AjoutavionComponent;
  let fixture: ComponentFixture<AjoutavionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjoutavionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjoutavionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

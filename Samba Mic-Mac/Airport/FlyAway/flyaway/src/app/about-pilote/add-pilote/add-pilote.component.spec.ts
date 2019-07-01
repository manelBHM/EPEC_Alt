import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPiloteComponent } from './add-pilote.component';

describe('AddPiloteComponent', () => {
  let component: AddPiloteComponent;
  let fixture: ComponentFixture<AddPiloteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddPiloteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPiloteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

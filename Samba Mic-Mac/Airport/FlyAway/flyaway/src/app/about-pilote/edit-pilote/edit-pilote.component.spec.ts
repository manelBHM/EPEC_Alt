import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPiloteComponent } from './edit-pilote.component';

describe('EditPiloteComponent', () => {
  let component: EditPiloteComponent;
  let fixture: ComponentFixture<EditPiloteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditPiloteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPiloteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

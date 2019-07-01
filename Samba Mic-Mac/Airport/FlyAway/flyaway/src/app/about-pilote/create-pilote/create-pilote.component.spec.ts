import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePiloteComponent } from './create-pilote.component';

describe('CreatePiloteComponent', () => {
  let component: CreatePiloteComponent;
  let fixture: ComponentFixture<CreatePiloteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatePiloteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatePiloteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

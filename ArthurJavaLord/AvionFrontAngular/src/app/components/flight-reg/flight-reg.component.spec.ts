import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightRegComponent } from './flight-reg.component';

describe('FlightRegComponent', () => {
  let component: FlightRegComponent;
  let fixture: ComponentFixture<FlightRegComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlightRegComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightRegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

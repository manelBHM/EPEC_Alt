import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPiloteComponent } from './view-pilote.component';

describe('ViewPiloteComponent', () => {
  let component: ViewPiloteComponent;
  let fixture: ComponentFixture<ViewPiloteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPiloteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPiloteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

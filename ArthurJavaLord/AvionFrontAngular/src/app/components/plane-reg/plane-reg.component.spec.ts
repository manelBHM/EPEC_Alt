import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaneRegComponent } from './plane-reg.component';

describe('PlaneRegComponent', () => {
  let component: PlaneRegComponent;
  let fixture: ComponentFixture<PlaneRegComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlaneRegComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaneRegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
